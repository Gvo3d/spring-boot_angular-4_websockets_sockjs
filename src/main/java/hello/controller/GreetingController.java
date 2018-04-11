package hello.controller;

import hello.dto.Greeting;
import hello.dto.HelloMessage;
import hello.dto.SubscribedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting1(HelloMessage message) throws Exception {
        System.out.println("Invoked: greeting1");
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


    @MessageMapping("/private")
    public void greeting2(SubscribedMessage message) throws Exception {
        System.out.println("Invoked: greeting2");
        System.out.println("Message:"+ message);
        String sessionId = message.getIdentity();
        Greeting greeting = new Greeting("Hello, " + message.getName() + "!");
        System.out.println("Session:" + sessionId);
        messagingTemplate.convertAndSendToUser(sessionId, "/queue/reply", greeting, createHeaders(sessionId));
    }



    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }
}

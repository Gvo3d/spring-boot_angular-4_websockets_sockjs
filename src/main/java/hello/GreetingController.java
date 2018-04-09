package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting1(HelloMessage message, HttpSession session) throws Exception {
        System.out.println("Invoked: greeting1");
        System.out.println("Session: "+ session);
//        System.out.println("Session id: "+getSessionId());
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


    @MessageMapping("/private")
    public void greeting2(HelloMessage message) throws  Exception {
        System.out.println("Invoked: greeting2");
        Greeting greeting = new Greeting("Hello, " + message.getName() + "!");
        messagingTemplate.convertAndSendToUser("1", "/queue/reply", greeting, createHeaders("1"));
    }


    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }

//    private String getSessionId(){
//        return RequestContextHolder.currentRequestAttributes().getSessionId();
//    }
}

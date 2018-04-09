package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SessionController {

    @GetMapping(value = "session")
    public String getSession(HttpServletRequest request){
        return request.getSession().getId();
    }
}

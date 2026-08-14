package crossmade.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FirstController {

    @GetMapping("hello")
    public String getHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/post")
    public String Post(@RequestBody() String message) {
        return "received: "+ message;    
    }

    @PostMapping("/post-order")
    public String Post(@RequestBody() Order order) {
        return "Order received: "+ order.toString() ;    
    }

    
}

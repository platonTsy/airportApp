package rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Greeting restGreeting(
            @RequestParam(value = "name", defaultValue = "World", required = false) String name
    ){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}

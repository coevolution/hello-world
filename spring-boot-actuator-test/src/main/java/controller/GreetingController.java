package controller;

import hello.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lxp
 * @date 2019/6/26 下午4:16
 * @Version 1.0
 */
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value ="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}

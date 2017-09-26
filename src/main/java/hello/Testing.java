package hello;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hei")
    public String hei(HttpServletResponse response) {
        Cookie c = new Cookie("foo", "bar");
        System.out.println(c.getName());
        System.out.println(response.getHeader("Cookie"));
        response.addCookie(c);
        System.out.println(response.getHeader("Cookie"));
        return response.toString();
    }

}
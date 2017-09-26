package hello;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {

    private static final String template = "<pre>id:\t%o\ndiff:\t%o<pre>";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hei")
    public String hei(@RequestHeader(value="User-Agent", defaultValue="foo") String ua, HttpServletResponse response) {
        response.addCookie(new Cookie("foo", "bar"));
        Long before = System.currentTimeMillis();
        doStuff();
        Long after = System.currentTimeMillis();
        Long diff = after - before;
        return template.format(template, counter.getAndAdd(1), diff);
    }

    private void doStuff() {
        for(Integer i = 0; i < Integer.MAX_VALUE; i += 2) {
            i--;
        }
    }

}
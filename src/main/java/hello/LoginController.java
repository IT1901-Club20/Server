package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private List<Integer> log = new ArrayList<>();

    @GetMapping("/login")
    public LoginResponse login(@RequestParam(value="username", defaultValue="null") String username, @RequestParam(value="password", defaultValue="null") String password) {
        return new LoginResponse(username, password);
    }

}

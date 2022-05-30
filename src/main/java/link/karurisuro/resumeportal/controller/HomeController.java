package link.karurisuro.resumeportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "It works!";
    }

    @GetMapping("/edit")
    public String edit() {
        return "Edit page!";
    }

}

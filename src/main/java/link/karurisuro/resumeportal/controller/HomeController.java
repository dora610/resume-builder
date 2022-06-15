package link.karurisuro.resumeportal.controller;

import link.karurisuro.resumeportal.services.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Slf4j
public class HomeController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/")
    public String home() {
        return "It works!";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth route";
    }

    @PatchMapping("/delete")
    public String deleteInfo(
            @RequestParam String type,
            @RequestParam Integer index,
            Model model,
            Principal principal) throws Exception {

        log.debug("index : {}", index);
        String userName = principal.getName();
        String skillDeleted = userProfileService.updateUserSkill(userName, index);

        model.addAttribute("type", type);
        model.addAttribute("index", index);
        model.addAttribute("skillDeleted", skillDeleted);
        return "delete-info";
    }
}

package link.karurisuro.resumeportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileViewController {

    @GetMapping("/view/{template}/{userId}")
    public String view(
            @PathVariable(name = "userId") String userId,
            @PathVariable(name = "template", required = true) String templateId,
            Model model
    ) {
        model.addAttribute("userId", userId);
        String profileTemplate = "profile-templates/%s/index";
        return String.format(profileTemplate, templateId);
    }
}

package link.karurisuro.resumeportal.controller;

import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import link.karurisuro.resumeportal.services.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

@Controller
public class ProfileViewController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileViewController.class);

    private final String profileTemplate = "profile-templates/%d/index";

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/view/{userId}")
    public String view(
            @PathVariable(name = "userId") String userId,
            @RequestParam(name = "themeId", required = false) Integer themeId,
            Model model
    ) throws RuntimeException{
        UserProfile userProfile = userProfileService.getUserProfileByUserName(userId);

        int themeToSelect = themeId == null ? userProfile.getTheme() : themeId;

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);

        return String.format(this.profileTemplate, themeToSelect);
    }




    @GetMapping("/edit")
    public String edit(Model model, Principal principal) {
        logger.debug("principal: {}", principal);
        if (principal == null) {
            return "redirect:/auth";
        }
        String userName = principal.getName();
        model.addAttribute("userId", userName);

        UserProfile userProfile = userProfileService.getUserProfileByUserName(userName);
        model.addAttribute("userProfile", userProfile);

        return "profile-edit";
    }

    @PostMapping("/edit")
    public String postEdit(Model userAdded, Principal principal) {
        // get userId
        String userId = principal.getName();
        // save profile details
        // redirect to view upon successful save
        return "redirect:/view" + userId;
    }
}

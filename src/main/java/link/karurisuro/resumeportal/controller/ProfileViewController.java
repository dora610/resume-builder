package link.karurisuro.resumeportal.controller;

import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileViewController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileViewController.class);

    private final String profileTemplate = "profile-templates/%d/index";

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/view/{userId}")
    public String view(
            @PathVariable(name = "userId") String userId,
            @RequestParam(name = "themeId", required = false) Integer themeId,
            Model model
    ) {
        UserProfile userProfile = userProfileRepository
                .findByUserName(userId)
                .orElseThrow(() -> new RuntimeException("No such user found"));

        logger.debug("jobs: {}", userProfile.getJobs());

        int themeToSelect = themeId == null ? userProfile.getTheme(): themeId;

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);



        return String.format(this.profileTemplate, themeToSelect);
    }
}

package link.karurisuro.resumeportal.controller;

import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileViewController {

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

        model.addAttribute("userId", userId);

        int themeToSelect = themeId == null ? userProfile.getTheme(): themeId;

        return String.format(this.profileTemplate, themeToSelect);
    }
}

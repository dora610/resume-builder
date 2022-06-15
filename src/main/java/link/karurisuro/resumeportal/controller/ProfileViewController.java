package link.karurisuro.resumeportal.controller;

import link.karurisuro.resumeportal.models.Education;
import link.karurisuro.resumeportal.models.Job;
import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.services.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@Slf4j
public class ProfileViewController {
//    private static final Logger logger = LoggerFactory.getLogger(ProfileViewController.class);

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/view/{userName}")
    public String view(
            @PathVariable(name = "userName") String userName,
            @RequestParam(name = "themeId", required = false) Integer themeId,
            Model model
    ) throws Exception {
        UserProfile userProfile = userProfileService.getUserProfileByUserName(userName);

        int themeToSelect = themeId == null ? userProfile.getTheme() : themeId;

        model.addAttribute("userName", userName);
        model.addAttribute("userProfile", userProfile);

        String profileTemplate = "profile-templates/%d/index";
        return String.format(profileTemplate, themeToSelect);
    }


    @GetMapping("/edit")
    public String edit(Model model, Principal principal, @RequestParam(required = false) String add) throws Exception {
        log.debug("principal: {}", principal);
        if (principal == null) {
            return "redirect:/auth";
        }
        String userName = principal.getName();
        UserProfile userProfile = userProfileService.getUserProfileByUserName(userName);
        if (add!=null){
            switch (add){
                case "job":
                    userProfile.getJobs().add(new Job());
                    break;
                case "education":
                    userProfile.getEducations().add(new Education());
                    break;
                case "skill":
                    userProfile.getSkills().add("");
            }
        }
        model.addAttribute("userName", userName);
        model.addAttribute("userProfile", userProfile);

        return "profile-edit";
    }

    @PostMapping("/edit")
    public String postEdit(Model userAdded, Principal principal, @ModelAttribute UserProfile userProfile) throws Exception {
        log.debug("incoming request: {}",userProfile);
        // get userId
        String userName = principal.getName();
        // save profile details
//        userProfileService.savedUserProfile(userProfile, userName);
        // redirect to view upon successful save
        return "redirect:/view/" + userName;
    }

}

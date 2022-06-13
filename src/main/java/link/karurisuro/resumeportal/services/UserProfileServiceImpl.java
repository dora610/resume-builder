package link.karurisuro.resumeportal.services;

import link.karurisuro.resumeportal.models.User;
import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getUserProfileByUserName(String userName) throws RuntimeException{
        UserProfile userProfile = userProfileRepository
                .findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("No such user found"));
        return userProfile;
    }

    public void savedUserProfile(UserProfile userProfile) throws RuntimeException{
        if (userProfileRepository.existsById(userProfile.getId())) {
            userProfileRepository.saveAndFlush(userProfile);
        }else {
            new RuntimeException("No such user profile found");
        }
    }

    @Override
    public String updateUserSkill(String userName, int index) throws RuntimeException{
        UserProfile userProfile = userProfileRepository
                .findByUserName(userName)
                .orElseThrow(()-> new RuntimeException("User not found"));

        List<String> skills = userProfile.getSkills();
        String deletedSkill;
        try {
            deletedSkill = skills.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Invalid index provided");
        }

        userProfile.setSkills(skills);
        userProfileRepository.saveAndFlush(userProfile);
        return deletedSkill;
    }
}

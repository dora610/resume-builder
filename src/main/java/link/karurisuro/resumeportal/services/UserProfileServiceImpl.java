package link.karurisuro.resumeportal.services;

import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getUserProfileByUserName(String userId) throws RuntimeException{
        UserProfile userProfile = userProfileRepository
                .findByUserName(userId)
                .orElseThrow(() -> new RuntimeException("No such user found"));
        return userProfile;
    }
}

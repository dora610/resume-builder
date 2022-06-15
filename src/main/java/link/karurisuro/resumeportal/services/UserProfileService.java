package link.karurisuro.resumeportal.services;

import link.karurisuro.resumeportal.models.UserProfile;

public interface UserProfileService {
    UserProfile getUserProfileByUserName(String userId) throws Exception;

    String updateUserSkill(String userName, int index) throws Exception;

    void savedUserProfile(UserProfile userProfile, String userName) throws Exception;
}

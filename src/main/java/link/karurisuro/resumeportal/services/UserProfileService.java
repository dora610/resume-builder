package link.karurisuro.resumeportal.services;

import link.karurisuro.resumeportal.models.UserProfile;

public interface UserProfileService {
    UserProfile getUserProfileByUserName(String userId) throws RuntimeException;

    String updateUserSkill(String userName, int index) throws RuntimeException;

    void savedUserProfile(UserProfile userProfile) throws RuntimeException;
}

package link.karurisuro.resumeportal.services;

import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.EducationRepository;
import link.karurisuro.resumeportal.repository.JobRepository;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public UserProfile getUserProfileByUserName(String userName) throws Exception {
        UserProfile userProfile = userProfileRepository
                .findByUserName(userName)
                .orElseThrow(() -> new Exception("No such user found"));
        userProfile.getJobs().forEach(j -> log.debug("jobs: {}", j.getIsCurrentJob()));

        return userProfile;
    }

    public void savedUserProfile(UserProfile userProfile, String userName) throws Exception {
        UserProfile savedUserProfile = getUserProfileByUserName(userName);
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(userName);
        userProfile.getJobs().forEach(job -> job.setUserProfile(userProfile));
        userProfile.getEducations().forEach(edu -> edu.setUserProfile(userProfile));
        userProfileRepository.save(userProfile);
        jobRepository.saveAll(userProfile.getJobs());
        educationRepository.saveAll(userProfile.getEducations());
    }

    @Override
    public String updateUserSkill(String userName, int index) throws Exception {
        UserProfile userProfile = userProfileRepository
                .findByUserName(userName)
                .orElseThrow(() -> new Exception("User not found"));

        List<String> skills = userProfile.getSkills();
        String deletedSkill;
        try {
            deletedSkill = skills.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Invalid index provided");
        }

        userProfile.setSkills(skills);
        userProfileRepository.saveAndFlush(userProfile);
        return deletedSkill;
    }
}

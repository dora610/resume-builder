package link.karurisuro.resumeportal.repository;

import link.karurisuro.resumeportal.models.User;
import link.karurisuro.resumeportal.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserName(String userName);
}

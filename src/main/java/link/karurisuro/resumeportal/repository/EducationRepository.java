package link.karurisuro.resumeportal.repository;

import link.karurisuro.resumeportal.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
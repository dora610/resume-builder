package link.karurisuro.resumeportal.repository;

import link.karurisuro.resumeportal.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

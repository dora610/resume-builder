package link.karurisuro.resumeportal.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String company;
    private String designation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Boolean isCurrentJob;
    @ElementCollection(targetClass = String.class)
    private List<String> responsibilities = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    public Job(String company, String designation, LocalDate startDate, LocalDate endDate, boolean isCurrentJob, UserProfile userProfile) {
        this.company = company;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrentJob = isCurrentJob;
        this.userProfile = userProfile;
    }
}

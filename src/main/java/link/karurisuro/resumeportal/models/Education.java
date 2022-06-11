package link.karurisuro.resumeportal.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String qualification;
    private String institution;
    private Float percentage;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    public Education(String qualification, String institution, Float percentage, LocalDate startDate, LocalDate endDate, UserProfile userProfile) {
        this.qualification = qualification;
        this.institution = institution;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userProfile = userProfile;
    }
}

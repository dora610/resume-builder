package link.karurisuro.resumeportal.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    private int theme;
    private String summary;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userProfile")
    private List<Job> jobs = new ArrayList<>();

    private String pgUniversity;
    private LocalDate pgTo;
    private LocalDate pgFrom;
    private Float pgCGPA;
    private String ugUniversity;
    private LocalDate ugTo;
    private LocalDate ugFrom;
    private Float ugCGPA;
    private String higherSecondary;
    private LocalDate hsTo;
    private LocalDate hsFrom;
    private Float hsPercentage;
    private String secondary;
    private LocalDate sTo;
    private LocalDate sFrom;
    private Float sPercentage;
    @ElementCollection(targetClass = String.class)
    private List<String> skills = new ArrayList<>();

    public UserProfile(String userName, int theme, String summary, String firstName, String lastName, String email, String phone, String designation) {
        this.userName = userName;
        this.theme = theme;
        this.summary = summary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }
}

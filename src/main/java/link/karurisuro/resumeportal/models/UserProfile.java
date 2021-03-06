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
@ToString
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userProfile")
    private List<Education> educations = new ArrayList<>();

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

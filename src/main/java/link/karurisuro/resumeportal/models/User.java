package link.karurisuro.resumeportal.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;

    public User(String userName, String password, boolean active, String roles) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }
}

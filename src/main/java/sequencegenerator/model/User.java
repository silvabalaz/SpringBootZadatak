package sequencegenerator.model;

/**
 * Created by silva on 18.09.16..
 */

import org.hibernate.validator.constraints.NotEmpty;
import sequencegenerator.service.PasswordService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Lozinka i korisničko ime su obavezna polja")
    private String username;

    @NotEmpty(message = "Lozinka i korisničko ime su obavezna polja")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = PasswordService.getPasswordHash(password); }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, user='%s', password='%s']",
                id, username, password);
    }
}
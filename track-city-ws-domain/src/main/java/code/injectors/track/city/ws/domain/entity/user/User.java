package code.injectors.track.city.ws.domain.entity.user;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.entity.municipality.Municipality;

import javax.persistence.*;
import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Municipality municipality;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "manager")
    private List<User> subordinates;

    @ManyToOne
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<User> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<User> subordinates) {
        this.subordinates = subordinates;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

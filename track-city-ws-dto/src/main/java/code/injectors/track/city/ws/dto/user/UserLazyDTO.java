package code.injectors.track.city.ws.dto.user;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.Reference;

import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
public class UserLazyDTO extends AbstractDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Reference municipality;
    private Reference manager;
    private List<Reference> subordinates;
    private Reference role;

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

    public Reference getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Reference municipality) {
        this.municipality = municipality;
    }

    public Reference getManager() {
        return manager;
    }

    public void setManager(Reference manager) {
        this.manager = manager;
    }

    public List<Reference> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Reference> subordinates) {
        this.subordinates = subordinates;
    }

    public Reference getRole() {
        return role;
    }

    public void setRole(Reference role) {
        this.role = role;
    }
}

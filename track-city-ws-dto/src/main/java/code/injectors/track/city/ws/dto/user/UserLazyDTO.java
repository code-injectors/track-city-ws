package code.injectors.track.city.ws.dto.user;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.Reference;

import java.util.Date;

/**
 * @author Chatzakis Nikolaos
 */
public class UserLazyDTO extends AbstractDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String emailHash;
    private Reference municipality;
    private Reference manager;
    private Reference role;
    private Date createdAt;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
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

    public Reference getRole() {
        return role;
    }

    public void setRole(Reference role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

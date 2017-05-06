package code.injectors.track.city.ws.dto.user;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.municipality.MunicipalityDTO;

/**
 * @author Chatzakis Nikolaos
 */
public class UserDTO extends AbstractDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String emailHash;
    private MunicipalityDTO municipality;
    private UserDTO manager;
    private RoleDTO role;

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

    public MunicipalityDTO getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MunicipalityDTO municipality) {
        this.municipality = municipality;
    }

    public UserDTO getManager() {
        return manager;
    }

    public void setManager(UserDTO manager) {
        this.manager = manager;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}

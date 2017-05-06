package code.injectors.track.city.ws.dto.user;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.municipality.MunicipalityDTO;

import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
public class UserDTO extends AbstractDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private MunicipalityDTO municipality;
    private UserDTO manager;
    private List<UserDTO> subordinates;
    private RoleDTO role;

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

    public List<UserDTO> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<UserDTO> subordinates) {
        this.subordinates = subordinates;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}

package code.injectors.track.city.ws.dto.user;

import code.injectors.track.city.ws.dto.AbstractDTO;

/**
 * @author Chatzakis Nikolaos
 */
public class RoleDTO extends AbstractDTO {

    private String name;

    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

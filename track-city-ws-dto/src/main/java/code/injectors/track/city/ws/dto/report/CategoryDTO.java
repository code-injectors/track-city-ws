package code.injectors.track.city.ws.dto.report;

import code.injectors.track.city.ws.dto.AbstractDTO;

/**
 * @author Chatzakis Nikolaos
 */
public class CategoryDTO extends AbstractDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

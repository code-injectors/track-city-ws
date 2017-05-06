package code.injectors.track.city.ws.dto;

/**
 * @author Chatzakis Nikolaos
 */
public abstract class AbstractDTO {

    private String id;

    public AbstractDTO() {
    }

    public AbstractDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

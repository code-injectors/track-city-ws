package code.injectors.track.city.ws.dto.media;

import code.injectors.track.city.ws.dto.AbstractDTO;

/**
 * @author Chatzakis Nikolaos
 */
public class MediaDTO extends AbstractDTO {

    private String name;
    private String meta;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

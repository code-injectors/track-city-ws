package code.injectors.track.city.ws.domain.entity.media;

import code.injectors.track.city.ws.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
public class Media extends BaseEntity {

    private String name;

    private String meta;

    @Enumerated(EnumType.STRING)
    private MediaType type;

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

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }
}

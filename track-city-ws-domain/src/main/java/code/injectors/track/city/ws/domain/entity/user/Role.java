package code.injectors.track.city.ws.domain.entity.user;

import code.injectors.track.city.ws.domain.entity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
public class Role extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

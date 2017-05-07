package code.injectors.track.city.ws.domain.entity.user;

import code.injectors.track.city.ws.domain.entity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
public class Role extends BaseEntity {

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

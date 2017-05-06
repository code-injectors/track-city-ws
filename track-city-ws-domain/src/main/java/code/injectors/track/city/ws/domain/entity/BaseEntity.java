package code.injectors.track.city.ws.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Chatzakis Nikolaos
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "java-uuid", strategy = "code.injectors.track.city.ws.domain.config.UUIDGenerator")
    @GeneratedValue(generator = "java-uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        final BaseEntity that = (BaseEntity) o;

        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}

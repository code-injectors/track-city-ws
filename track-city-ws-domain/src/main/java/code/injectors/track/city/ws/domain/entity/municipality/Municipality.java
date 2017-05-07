package code.injectors.track.city.ws.domain.entity.municipality;

import code.injectors.track.city.ws.domain.entity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
public class Municipality extends BaseEntity {

    private String name;

    private Double longitude;

    private Double latitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}

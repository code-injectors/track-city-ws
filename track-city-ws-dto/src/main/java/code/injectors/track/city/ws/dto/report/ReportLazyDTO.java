package code.injectors.track.city.ws.dto.report;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.Reference;

import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
public class ReportLazyDTO extends AbstractDTO {

    private String status;
    private String title;
    private String description;
    private Double longitude;
    private Double latitude;
    private Reference creator;
    private Reference category;
    private List<Reference> media;
    private List<Reference> reviews;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Reference getCreator() {
        return creator;
    }

    public void setCreator(Reference creator) {
        this.creator = creator;
    }

    public Reference getCategory() {
        return category;
    }

    public void setCategory(Reference category) {
        this.category = category;
    }

    public List<Reference> getMedia() {
        return media;
    }

    public void setMedia(List<Reference> media) {
        this.media = media;
    }

    public List<Reference> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reference> reviews) {
        this.reviews = reviews;
    }
}

package code.injectors.track.city.ws.domain.entity.report;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.domain.entity.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
public class Report extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    private String title;

    private String description;

    private Double longitude;

    private Double latitude;

    @ManyToOne
    private User creator;

    @ManyToOne
    private Category category;

    @OneToMany
    private List<Media> media;

    @OneToMany
    private List<Review> reviews;

    private Date createdAt;

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

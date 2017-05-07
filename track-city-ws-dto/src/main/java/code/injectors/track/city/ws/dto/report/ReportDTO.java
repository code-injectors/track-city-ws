package code.injectors.track.city.ws.dto.report;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.media.MediaDTO;
import code.injectors.track.city.ws.dto.review.ReviewDTO;
import code.injectors.track.city.ws.dto.user.UserDTO;

import java.util.Date;
import java.util.List;

/**
 * @author Chatzakis Nikolaos
 */
public class ReportDTO extends AbstractDTO {

    private String status;
    private String title;
    private String description;
    private Double longitude;
    private Double latitude;
    private UserDTO creator;
    private CategoryDTO category;
    private List<MediaDTO> media;
    private List<ReviewDTO> reviews;
    private Integer upVotes;
    private Integer downVotes;
    private Integer visibleComments;
    private Integer allComments;
    private Date createdAt;

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

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<MediaDTO> getMedia() {
        return media;
    }

    public void setMedia(List<MediaDTO> media) {
        this.media = media;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
    }

    public Integer getVisibleComments() {
        return visibleComments;
    }

    public void setVisibleComments(Integer visibleComments) {
        this.visibleComments = visibleComments;
    }

    public Integer getAllComments() {
        return allComments;
    }

    public void setAllComments(Integer allComments) {
        this.allComments = allComments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

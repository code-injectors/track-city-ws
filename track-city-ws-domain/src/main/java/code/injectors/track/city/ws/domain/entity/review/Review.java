package code.injectors.track.city.ws.domain.entity.review;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.entity.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Chatzakis Nikolaos
 */
@Entity
public class Review extends BaseEntity {

    private Boolean isUpvote;

    private String comment;

    @ManyToOne
    private User user;

    public Boolean getUpvote() {
        return isUpvote;
    }

    public void setUpvote(Boolean upvote) {
        isUpvote = upvote;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

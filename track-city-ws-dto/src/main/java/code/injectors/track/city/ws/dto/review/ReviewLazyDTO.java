package code.injectors.track.city.ws.dto.review;

import code.injectors.track.city.ws.dto.AbstractDTO;
import code.injectors.track.city.ws.dto.Reference;

/**
 * @author Chatzakis Nikolaos
 */
public class ReviewLazyDTO extends AbstractDTO {

    private Boolean isUpvote;
    private String comment;
    private Reference user;

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

    public Reference getUser() {
        return user;
    }

    public void setUser(Reference user) {
        this.user = user;
    }
}

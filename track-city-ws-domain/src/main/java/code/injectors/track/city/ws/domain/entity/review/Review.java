package code.injectors.track.city.ws.domain.entity.review;

import code.injectors.track.city.ws.domain.entity.BaseEntity;
import code.injectors.track.city.ws.domain.entity.report.Report;
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

    private Boolean hidden = false;

    @ManyToOne
    private User user;

    @ManyToOne
    private Report report;

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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}

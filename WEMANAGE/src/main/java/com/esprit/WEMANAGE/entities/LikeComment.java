package com.esprit.WEMANAGE.entities;

import javax.persistence.*;

@Entity
@Table(name = "likeComment")

public class LikeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    private Comment comment;
    private Long userId;


    private  boolean isLike;

    public boolean isLike() {
        return isLike;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}

package com.esprit.WEMANAGE.entities;
import javax.persistence.*;

@Entity
@Table(name = "likePost")

public class LikePost {
   public LikePost(){
       super();
   }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;
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

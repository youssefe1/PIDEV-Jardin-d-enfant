package com.esprit.WEMANAGE.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String textContent;
    private String urlMedia;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;
    @OneToMany
    @JoinColumn(name="likePostId", referencedColumnName="id")

    private Set<LikePost> likePosts =new HashSet<>();

    public Set<LikePost> getLikes() {
        return likePosts;
    }

    public void setLikes(Set<LikePost> likePosts) {
        this.likePosts = likePosts;
    }

    public long getId() {
        return id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getUrlMedia() {
        return urlMedia;
    }

    public void setUrlMedia(String urlMedia) {
        this.urlMedia = urlMedia;
    }

    public Date getCreatedDate() {
        return createdDate;
    }



    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }



    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}

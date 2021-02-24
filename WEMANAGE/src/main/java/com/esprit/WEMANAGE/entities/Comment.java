package com.example.demo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private  long Id;
        private String content;
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @OneToMany
    @JoinColumn(name="likeCommentId", referencedColumnName="id")

    private List<LikeComment> likeComments=new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return Id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<LikeComment> getLikeComments() {
        return likeComments;
    }

    public void setLikeComments(List<LikeComment> likeComments) {
        this.likeComments = likeComments;
    }
}

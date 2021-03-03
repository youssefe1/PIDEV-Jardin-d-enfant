package com.esprit.spring.dto;

public class PostDto {
    private String postContent;
    private String urlMedia;
    private Long postId;
    private long UserId;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getPostContent() {
        return postContent;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getUrlMedia() {
        return urlMedia;
    }

    public void setUrlMedia(String urlMedia) {
        this.urlMedia = urlMedia;
    }
}

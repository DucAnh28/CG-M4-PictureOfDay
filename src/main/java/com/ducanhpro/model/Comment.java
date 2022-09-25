package com.ducanhpro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private int point;
    private String feedback;
    private Date date;
    private int likeOfComment;

    public Comment() {
    }

    public Comment(Long id, String author, int point, String feedback, int like) {
        this.id = id;
        this.author = author;
        this.point = point;
        this.feedback = feedback;
        this.likeOfComment = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikeOfComment() {
        return likeOfComment;
    }

    public void setLikeOfComment(int likeOfComment) {
        this.likeOfComment = likeOfComment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

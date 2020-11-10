package com.dealerStat.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(CommentPK.class)
@Table(name = "comment", schema = "public")
public class Comment {
    private int id;
    private String message;
    private int idUser;
    private String approved;
    private Date createdAt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message", nullable = false, length = 2000)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Id
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "approved", nullable = false, length = 10)
    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                idUser == comment.idUser &&
                Objects.equals(message, comment.message) &&
                Objects.equals(approved, comment.approved) &&
                Objects.equals(createdAt, comment.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, idUser, approved, createdAt);
    }
}

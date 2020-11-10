package com.dealerStat.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommentPK implements Serializable {
    private Integer id;
    private Integer idUser;

    @Column(name = "id", nullable = false)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "id_user", nullable = false)
    @Id
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentPK commentPK = (CommentPK) o;
        return Objects.equals(id, commentPK.id) &&
                Objects.equals(idUser, commentPK.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser);
    }
}

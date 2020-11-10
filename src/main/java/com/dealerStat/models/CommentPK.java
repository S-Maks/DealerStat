package com.dealerStat.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommentPK implements Serializable {
    private int id;
    private int idUser;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_user", nullable = false)
    @Id
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentPK commentPK = (CommentPK) o;
        return id == commentPK.id &&
                idUser == commentPK.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser);
    }
}

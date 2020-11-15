package com.dealerStat.store.dto;

import com.dealerStat.store.model.RoleEnum;

import java.sql.Date;

public class UserDto {

    private Long id;
    private RoleEnum roleName;
    private String firstName;
    private String lastName;
    private String email;
    private String userPassword;
    private Date createdAt;

    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }

    public RoleEnum getRoleName() {
        return roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

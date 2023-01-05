package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nick")
    private String nick;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

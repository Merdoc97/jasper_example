package com.jasper.example.model;

import javax.persistence.*;

/**
 * Created by artyov.igor on 17.07.2016.
 */
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID",nullable = false)
    private int id;

    @Column(name = "USER_NAME",nullable = false,length = 20)
    private String name;

    @Column(name = "USER_FIRST_NAME",nullable = false,length = 20)
    private String firstName;

    @Column(name = "USER_EMAIL",nullable = false,length = 20)
    private String email;

    public Users() {
    }

    public Users(int id, String name, String firstName, String email) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return id == users.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

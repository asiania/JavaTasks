package org.example.task5.dto;


public class User {
    private long id;
    private String username;

    public User() {
    }

    public User(long id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

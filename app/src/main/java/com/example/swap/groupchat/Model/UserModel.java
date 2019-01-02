package com.example.swap.groupchat.Model;

public class UserModel {
    public UserModel(String name, int id) {
        this.userName=name;
        this.userId=id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String userName;
    private int userId;
}
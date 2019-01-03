package com.example.swap.groupchat.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageStatus implements Serializable{
    int ss;

    public ArrayList<UserModel> getUserModelList() {
        return userModelList;
    }

    public void setUserModelList(ArrayList<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    ArrayList<UserModel> userModelList;
    public boolean isSection() {
        return isSection;
    }

    public void setSection(boolean section) {
        isSection = section;
    }

    public boolean isSection;

    public MessageStatus(int userId,int status,String time){
        this.userId=userId;
        this.status=status;
        this.time=time;
    }

    public MessageStatus(int userId, String time, boolean b) {
        this.userId=userId;
        this.time=time;
        this.isSection=b;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private int userId;
    private int status;
    private String time;

}

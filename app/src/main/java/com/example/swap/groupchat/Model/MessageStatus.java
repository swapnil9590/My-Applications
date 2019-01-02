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

    public MessageStatus(int userId,int status,long time){
        this.userId=userId;
        this.status=status;
        this.time=time;
    }

    public MessageStatus(int userId, long time, boolean b) {
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private int userId;
    private int status;
    private long time;

}

package com.example.swap.groupchat.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageObject implements Serializable {

    public MessageObject(int msgId, String msgTxt, int messageTime) {
        this.messageId=msgId;
        this.messageTime=messageTime;
        this.messageText=msgTxt;
    }

    /*public MessageObject(int msgId, String msgTxt, int messageTime,ArrayList<MessageStatus> messageStatus,boolean sent) {
        this.messageId=msgId;
        this.messageTime=messageTime;
        this.messageText=msgTxt;
        this.messageStatus=messageStatus;
        this.sent=sent;
    }
*/
    public MessageObject(int msgId, String msgTxt, int messageTime,boolean sent) {
        this.messageId=msgId;
        this.messageTime=messageTime;
        this.messageText=msgTxt;
        this.messageStatus=messageStatus;
        this.sent=sent;
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public ArrayList<MessageStatus> getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(ArrayList<MessageStatus> messageStatus) {
        this.messageStatus = messageStatus;
    }

    private int messageId;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    private String messageText;
    private long messageTime;
    private boolean sent;
    private ArrayList<MessageStatus> messageStatus;


/*    // Parcelling part
    public MessageObject(Parcel in){
        this.messageId = in.readInt();
        this.messageText = in.readString();
       // this.messageStatus =  in.readArrayList();
        this.messageTime =  in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.messageId);
        dest.writeString(this.messageText);
        dest.writeLong(this.messageTime);
        //dest.writeArray(this.messageStatus);
    }*/
}

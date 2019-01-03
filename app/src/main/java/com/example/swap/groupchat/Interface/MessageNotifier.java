package com.example.swap.groupchat.Interface;

import com.example.swap.groupchat.Model.MessageStatus;

import java.util.ArrayList;

public interface MessageNotifier {
  public void updateMessageStatus (int messageId,  ArrayList<MessageStatus> messageStatus,int pos);

}

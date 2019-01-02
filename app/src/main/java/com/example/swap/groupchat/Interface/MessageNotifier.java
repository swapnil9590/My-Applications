package com.example.swap.groupchat.Interface;

import com.example.swap.groupchat.Model.MessageStatus;

public interface MessageNotifier {
  public void updateMessageStatus (int messageId, MessageStatus messageStatus);

}

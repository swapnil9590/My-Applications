package com.example.swap.groupchat.Interface;



public interface Subject {
    public void register(MessageNotifier observer);
    public void unregister(MessageNotifier observer);
    public void notifyObservers();

}
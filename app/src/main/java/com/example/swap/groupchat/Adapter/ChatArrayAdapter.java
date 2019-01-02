package com.example.swap.groupchat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.swap.groupchat.Activity.MessageInfoActivity;
import com.example.swap.groupchat.Activity.MsgInfoActivity;
import com.example.swap.groupchat.Model.ChatMessage;
import com.example.swap.groupchat.Model.MessageObject;
import com.example.swap.groupchat.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private RelativeLayout relative_view;
    //private List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
    private List<MessageObject> chatMessageList = new ArrayList<MessageObject>();
    private Context context;


    @Override
    public void add(ChatMessage object) {
        //chatMessageList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context context, int textViewResourceId, ArrayList<MessageObject> msgArrayList) {
        super(context, textViewResourceId);
        this.context = context;
        this.chatMessageList = msgArrayList;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

   /* public MessageObject getItem(int index)
    {
        return this.chatMessageList.get(index);
    }*/

    public View getView(final int position, View convertView, ViewGroup parent) {
       // MessageObject chatMessageObj = getItem(position);
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       /* if (chatMessageObj.left) {*/
            row = inflater.inflate(R.layout.my_message, parent, false);
            relative_view = (RelativeLayout) row.findViewById(R.id.relative_view);

            relative_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context,MsgInfoActivity.class);
                    Log.d("listPos->>",position+"");
                    Bundle args = new Bundle();
                    args.putSerializable("chatList",(Serializable)chatMessageList);
                    i.putExtra("bundle",args);
                    i.putExtra("pos", position);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });
        /*}else{*/
           // row = inflater.inflate(R.layout.their_message, parent, false);
        //}
        chatText = (TextView) row.findViewById(R.id.message_body);


        chatText.setText(chatMessageList.get(position).getMessageText());



        return row;
    }
}
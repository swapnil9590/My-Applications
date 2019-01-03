package com.example.swap.groupchat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.swap.groupchat.Interface.MessageNotifier;
import com.example.swap.groupchat.Model.ChatMessage;
import com.example.swap.groupchat.Model.MessageObject;
import com.example.swap.groupchat.R;

import java.util.ArrayList;
import java.util.List;

public class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private ImageView imageView;
    private ImageView imageView2;
    private RelativeLayout relative_view;
    //private List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
    private List<MessageObject> chatMessageList = new ArrayList<MessageObject>();
    private Context context;
    MessageNotifier messageNotifier;

    @Override
    public void add(ChatMessage object) {
        //chatMessageList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context context, int textViewResourceId, ArrayList<MessageObject> msgArrayList,MessageNotifier msgNotifierListener) {
        super(context, textViewResourceId);
        this.context = context;
        this.chatMessageList = msgArrayList;
        this.messageNotifier=msgNotifierListener;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

   /* public MessageObject getItem(int index)
    {
        return this.chatMessageList.get(index);
    }*/

    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.my_message, parent, false);
            relative_view = (RelativeLayout) row.findViewById(R.id.relative_view);
            chatText = (TextView) row.findViewById(R.id.message_body);
            imageView = (ImageView) row.findViewById(R.id.img_status);
            imageView2 = (ImageView) row.findViewById(R.id.img_status1);

            relative_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    messageNotifier.updateMessageStatus(chatMessageList.get(position).getMessageId(),chatMessageList.get(position).getMessageStatus(),position);
                }
            });

         if(chatMessageList.get(position).isSent()){
             imageView2.setImageResource(R.drawable.msg_sent);
             imageView.setImageResource(R.drawable.msg_delieverd);
         }else {
             imageView.setImageResource(R.drawable.msg_delieverd);
         }

        chatText.setText(chatMessageList.get(position).getMessageText());



        return row;
    }
}
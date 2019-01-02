package com.example.swap.groupchat.Activity;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.swap.groupchat.Adapter.ChatArrayAdapter;
import com.example.swap.groupchat.Interface.MessageNotifier;
import com.example.swap.groupchat.Model.ChatMessage;
import com.example.swap.groupchat.Model.MessageObject;
import com.example.swap.groupchat.Model.MessageStatus;
import com.example.swap.groupchat.Model.UserModel;
import com.example.swap.groupchat.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MessageNotifier{
    private static final String TAG = "MainActivity";

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonSend;
    private boolean side = false;
    private ArrayList<MessageStatus> mStatusList=new ArrayList<>();
    ArrayList<MessageObject> msgArrayList=new ArrayList<>();
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initialiseViews();

        initialiseArralist();

        setAdpterView();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendChatMessage();
            }
        });


    }

    private void setAdpterView() {

        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.my_message,msgArrayList);
        listView.setAdapter(chatArrayAdapter);

        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatArrayAdapter);
        //to scroll the list view to bottom on data change
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });
    }

    private void initialiseViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Group Chat");
        buttonSend = (Button) findViewById(R.id.send);
        listView = (ListView) findViewById(R.id.msgview);
    }

    private void initialiseArralist() {

        HashMap<Integer, String> userMap = new HashMap<>();
        userMap.put(1,"Swapnil");
        userMap.put(2,"Pravin");
        userMap.put(3,"Digvijay");
        userMap.put(4,"Jatin");
        userMap.put(5,"Deepak");


        mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,1,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,1,1215));
        mStatusList.add(new MessageStatus(5,1,1212));



        msgArrayList.add(new MessageObject(1,"Hello",5,mStatusList));
        mStatusList=new ArrayList<>();

        mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,1,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,2,1215));
        mStatusList.add(new MessageStatus(5,2,1212));

        msgArrayList.add(new MessageObject(2,"Hello,hii guys",6,mStatusList));

        mStatusList=new ArrayList<>();

        mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,1,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,1,1215));
        mStatusList.add(new MessageStatus(5,2,1212));

        msgArrayList.add(new MessageObject(3,"Where are you now",7,mStatusList));


    }

    private boolean sendChatMessage() {
        chatArrayAdapter.add(new ChatMessage(side, chatText.getText().toString()));
        chatText.setText("");
        side = !side;
        return true;
    }

    @Override
    public void updateMessageStatus(int messageId, MessageStatus messageStatus) {

    }
}
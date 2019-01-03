package com.example.swap.groupchat.Activity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MessageNotifier{
    private static final String TAG = "MainActivity1";

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonSend;
    private boolean side = false;
    private ArrayList<MessageStatus> mStatusList=new ArrayList<>();
    ArrayList<MessageObject> msgArrayList=new ArrayList<>();
    Toolbar toolbar;
    MessageNotifier messageNotifier;
    HashMap<Integer, String> userMap = new HashMap<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        messageNotifier=this;
        initialiseViews();

        initialiseArraylist();

        setAdpterView();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendChatMessage();
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

    private void initialiseArraylist() {


        userMap.put(1,"Swapnil");
        userMap.put(2,"Pravin");
        userMap.put(3,"Digvijay");
        userMap.put(4,"Jatin");
        userMap.put(5,"Deepak");


        /*mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,1,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,1,1215));
        mStatusList.add(new MessageStatus(5,1,1212));*/

        msgArrayList.add(new MessageObject(1,"Hello",5,true));

        /*mStatusList=new ArrayList<>();
        mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,1,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,2,1215));
        mStatusList.add(new MessageStatus(5,2,1212));*/

        msgArrayList.add(new MessageObject(2,"Hello,hii guys",6,true));



        /*
        mStatusList=new ArrayList<>();
        mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,1,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,1,1215));
        mStatusList.add(new MessageStatus(5,2,1212));*/

        msgArrayList.add(new MessageObject(3,"Where are you now",7,false));

    }

    private void setAdpterView() {

        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.my_message,msgArrayList,messageNotifier);
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


    private boolean sendChatMessage() {
        chatArrayAdapter.add(new ChatMessage(side, chatText.getText().toString()));
        chatText.setText("");
        side = !side;
        return true;
    }

    @Override
    public void updateMessageStatus(int messageId, ArrayList<MessageStatus> mStatusList1,int pos) {
        ArrayList<MessageStatus> mStatusList=new ArrayList<>();

        switch (messageId){

                case 1:

                    mStatusList.add(new MessageStatus(1,1,"5 a.m."));
                    mStatusList.add(new MessageStatus(2,1,"6 a.m."));
                    mStatusList.add(new MessageStatus(3,1,"7 a.m."));
                    mStatusList.add(new MessageStatus(4,1,"8 a.m."));
                    mStatusList.add(new MessageStatus(5,1,"9 a.m."));

                break;

                case 2:

                    mStatusList.add(new MessageStatus(1,1,"8 a.m."));
                    mStatusList.add(new MessageStatus(2,1,"9 a.m."));
                    mStatusList.add(new MessageStatus(3,1,"10 a.m."));
                    mStatusList.add(new MessageStatus(4,2,"8 a.m."));
                    mStatusList.add(new MessageStatus(5,2,"9 a.m."));

                break;

                case 3:

                    mStatusList.add(new MessageStatus(1,1,"5 p.m."));
                    mStatusList.add(new MessageStatus(2,1,"7 p.m."));
                    mStatusList.add(new MessageStatus(3,1,"8 p.m."));
                    mStatusList.add(new MessageStatus(4,1,"9 p.m."));
                    mStatusList.add(new MessageStatus(5,2,"8 p.m."));

                break;

        }

        Intent i=new Intent(MainActivity.this,MsgInfoActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("chatList",mStatusList);
        i.putExtra("bundle",args);
        i.putExtra("msg",msgArrayList.get(pos).getMessageText());
        i.putExtra("usermap",userMap);
        /*i.putExtra("pos", position);*/
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }
}
package com.example.swap.groupchat.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.swap.groupchat.Adapter.MsgInfoAdapter;
import com.example.swap.groupchat.Model.MessageObject;
import com.example.swap.groupchat.Model.MessageStatus;
import com.example.swap.groupchat.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MsgInfoActivity extends AppCompatActivity  {
    private MsgInfoAdapter mAdapter;
    private ArrayList<MessageStatus> mSectionList;
    private ArrayList<MessageStatus> mSectionList2=new ArrayList<>();
    private ArrayList<MessageObject> mChatList=new ArrayList<>();
    private ArrayList<MessageStatus> mStatusList;
    HashMap<Integer, String> userMap = new HashMap<>();
    RecyclerView recyclerView;
    //private String[] mCountries;
    private int pos;
    TextView textView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_info);
        initialiseView();
        setupToolBar();

        mSectionList = new ArrayList<>();
        Bundle b=getIntent().getExtras();
        Bundle args =getIntent().getBundleExtra("bundle");
        mStatusList = (ArrayList<MessageStatus>) args.getSerializable("chatList");
        userMap = (HashMap<Integer,String>) b.getSerializable("usermap");
        textView.setText(b.getString("msg"));


        getReadUserStatus();
        setRecyclerview();



    }

    private void setRecyclerview() {
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MsgInfoAdapter(mSectionList,userMap, this);
        recyclerView.setAdapter(mAdapter);
    }

    private void initialiseView() {
        textView=findViewById(R.id.txtmsg);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
         recyclerView = (RecyclerView) findViewById(R.id.read_recycler_view);
    }

    private void setupToolBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Message Info");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


    private void getReadUserStatus() {

        Collections.sort(mStatusList, new Comparator<MessageStatus>() {
            @Override
            public int compare(MessageStatus user1, MessageStatus user2) {
                return user1.getStatus()- user2.getStatus();            }
        });

        int section = 0;

        for (int i = 0; i < mStatusList.size(); i++) {
            MessageStatus user = mStatusList.get(i);
            if(user.getStatus()==2&&section==0){
                mSectionList.add(new MessageStatus(00, 00+"", false));
                section=2;
            }
                mSectionList.add(new MessageStatus(user.getUserId(), user.getTime(), true));
        }


    }


}

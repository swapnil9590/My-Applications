package com.example.swap.groupchat.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.swap.groupchat.Adapter.MsgInfoAdapter;
import com.example.swap.groupchat.Interface.MessageNotifier;
import com.example.swap.groupchat.Interface.Subject;
import com.example.swap.groupchat.Model.MessageObject;
import com.example.swap.groupchat.Model.MessageStatus;
import com.example.swap.groupchat.Model.UserModel;
import com.example.swap.groupchat.Other.CountriesAdapter;
import com.example.swap.groupchat.Other.CountriesModel;
import com.example.swap.groupchat.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MsgInfoActivity extends AppCompatActivity implements Subject {
    private MsgInfoAdapter mAdapter;
    private ArrayList<MessageStatus> mSectionList;
    private ArrayList<MessageStatus> mSectionList2=new ArrayList<>();
    private ArrayList<MessageObject> mChatList=new ArrayList<>();
    private ArrayList<MessageStatus> mStatusList;
    //private String[] mCountries;
    private int pos;
    TextView textView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
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

        Bundle b=getIntent().getExtras();
        Bundle args =getIntent().getBundleExtra("bundle");
        mChatList = (ArrayList<MessageObject>) args.getSerializable("chatList");

        pos=b.getInt("pos");
        Log.d("position->>>",pos+"");
        //mChatList =  (ArrayList<MessageObject>)getIntent().getSerializableExtra("chatList");
        //mStatusList=mChatList.get(pos).getMessageStatus();
        mStatusList = new ArrayList<MessageStatus>(mChatList.get(pos).getMessageStatus());
        Log.d("arralistSizeAndMsg->>>",mStatusList.size()+" msg:"+mChatList.get(pos).getMessageText()+" User_id::"+mStatusList.get(4).getUserId()+" 5status:"+mStatusList.get(4).getStatus());

        textView=findViewById(R.id.txtmsg);
        textView.setText(mChatList.get(pos).getMessageText());
       //mCountries = getApplicationContext().getResources().getStringArray(R.array.countries);
        /*ArrayList<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel("Swapnil",1));
        userModels.add(new UserModel("Pravin",2));
        userModels.add(new UserModel("Digvijay",3));
        userModels.add(new UserModel("Akshay",4));
        userModels.add(new UserModel("Jatin",5));*/

        HashMap<Integer, String> userMap = new HashMap<>();
        userMap.put(1,"Swapnil");
        userMap.put(2,"Pravin");
        userMap.put(3,"Digvijay");
        userMap.put(4,"Jatin");
        userMap.put(5,"Deepak");


       /* mStatusList.add(new MessageStatus(1,1,1216));
        mStatusList.add(new MessageStatus(2,2,1212));
        mStatusList.add(new MessageStatus(3,1,1213));
        mStatusList.add(new MessageStatus(4,2,1215));
        mStatusList.add(new MessageStatus(5,1,1212));
*/

        mSectionList = new ArrayList<>();
        getHeaderListLatter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.read_recycler_view);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MsgInfoAdapter(mSectionList,userMap, this);
        recyclerView.setAdapter(mAdapter);

    }


    private void getHeaderListLatter() {

        Collections.sort(mStatusList, new Comparator<MessageStatus>() {
            @Override
            public int compare(MessageStatus user1, MessageStatus user2) {
                return user1.getStatus()- user2.getStatus();            }
        });

        String lastHeader = "";
        int section = 0;

        for (int i = 0; i < mStatusList.size(); i++) {
            MessageStatus user = mStatusList.get(i);
           // String header = String.valueOf(user.getUserName().charAt(0)).toUpperCase();
            String header = "";
            if(user.getStatus()==2&&section==0){
                mSectionList.add(new MessageStatus(00, 00, false));
                section=2;
              //  mSectionList.add(new MessageStatus(user.getUserId(), user.getTime(), true));
            }
                mSectionList.add(new MessageStatus(user.getUserId(), user.getTime(), true));
        }


    }

    @Override
    public void register(MessageNotifier observer) {

    }

    @Override
    public void unregister(MessageNotifier observer) {

    }

    @Override
    public void notifyObservers() {

    }
}

package com.example.swap.groupchat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swap.groupchat.Model.MessageStatus;

import com.example.swap.groupchat.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MsgInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SECTION_VIEW = 0;
    public static final int CONTENT_VIEW = 1;

    ArrayList<MessageStatus> mCountriesModelList;
    HashMap<Integer,String> mUserMapList;
    WeakReference<Context> mContextWeakReference;
    boolean flag=false;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.time);
          //  year = (TextView) view.findViewById(R.id.year);
        }
    }
    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitleTextview;

        public SectionHeaderViewHolder(View itemView) {
            super(itemView);
            headerTitleTextview = (TextView) itemView.findViewById(R.id.headerTitleTextview);
        }
    }

    public MsgInfoAdapter(ArrayList<MessageStatus> mCountriesModelList, HashMap<Integer,String> mUserMapList, Context context) {
        this.mCountriesModelList = mCountriesModelList;
        this.mUserMapList = mUserMapList;
        this.mContextWeakReference = new WeakReference<Context>(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView =null;

        Context context = mContextWeakReference.get();

        if (viewType == SECTION_VIEW) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_title, parent, false);
            return new SectionHeaderViewHolder(itemView);
        }

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
    }



    @Override
    public int getItemViewType(int position) {

        if (!mCountriesModelList.get(position).isSection) {
            return SECTION_VIEW;
        } else {
            return CONTENT_VIEW;
        }

    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        Context context = mContextWeakReference.get();
        if (context == null) {
            return;
        }


        if (SECTION_VIEW == getItemViewType(position)) {

            MsgInfoAdapter.SectionHeaderViewHolder sectionHeaderViewHolder = (MsgInfoAdapter.SectionHeaderViewHolder) holder;
            MessageStatus sectionItem = mCountriesModelList.get(position);
            sectionHeaderViewHolder.headerTitleTextview.setText("Deliver To");
            return;
        }



        MsgInfoAdapter.MyViewHolder itemViewHolder = (MsgInfoAdapter.MyViewHolder) holder;
        MessageStatus currentUser = ((MessageStatus) mCountriesModelList.get(position));
        //itemViewHolder.nameTextview.setText(currentUser.name);
        //if(mUserMapList.containsKey(currentUser.getUserId()))
        itemViewHolder.title.setText(mUserMapList.get(currentUser.getUserId())+"");
        //itemViewHolder.title.setText(currentUser.getUserId()+"");
        itemViewHolder.genre.setText(currentUser.getTime()+"");

    }



    @Override
    public int getItemCount() {
        return mCountriesModelList.size();
    }
}
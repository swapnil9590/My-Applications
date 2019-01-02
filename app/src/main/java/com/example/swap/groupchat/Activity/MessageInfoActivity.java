package com.example.swap.groupchat.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.swap.groupchat.Adapter.DelivereAdapter;
import com.example.swap.groupchat.Adapter.MoviesAdapter;
import com.example.swap.groupchat.Adapter.SimpleAdapter;
import com.example.swap.groupchat.Adapter.SimpleSectionedRecyclerViewAdapter;
import com.example.swap.groupchat.Model.Movie;
import com.example.swap.groupchat.R;

import java.util.ArrayList;
import java.util.List;

public class MessageInfoActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private List<Movie> deliverList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView mRecyclerView;
    private RecyclerView deliveRecyclerView;
    private MoviesAdapter mAdapter;
    private DelivereAdapter mDeliverAdapter;
    Toolbar toolbar;

    BottomSheetBehavior sheetBehavior;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        //sheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        recyclerView = (RecyclerView) findViewById(R.id.read_recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();


        deliveRecyclerView = (RecyclerView) findViewById(R.id.deliver_recycler_view);


        mDeliverAdapter = new DelivereAdapter(deliverList);
        RecyclerView.LayoutManager mLayoutManager_ = new LinearLayoutManager(getApplicationContext());
        deliveRecyclerView.setLayoutManager(mLayoutManager_);
        deliveRecyclerView.setItemAnimator(new DefaultItemAnimator());
        deliveRecyclerView.setAdapter(mDeliverAdapter);

        prepareMovieData_();

/*
        //Your RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.read_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        //Your RecyclerView.Adapter
        mAdapter = new SimpleAdapter(this,sCheeseStrings);


        //This is the code to provide a sectioned list
        List<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        //Sections
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"Section 1"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(5,"Section 2"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(12,"Section 3"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(14,"Section 4"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(20,"Section 5"));

        //Add your adapter to the sectionAdapter
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(this,R.layout.section,R.id.section_text,mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecyclerView.setAdapter(mSectionedAdapter);
        You can customize the section layout, ch
*/

    }

    private void prepareMovieData_() {

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        deliverList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        deliverList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        deliverList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        deliverList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        deliverList.add(movie);
        mDeliverAdapter.notifyDataSetChanged();

    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }
}
package com.example.rapid.stickyrecyclerviewdemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;

public class MainActivity extends AppCompatActivity {

    RecyclerAdapter mRecyclerAdapter;
    RecyclerView.LayoutManager mRecyclerLayoutManager;
    RecyclerView mRecyclerView;
    List<Contact> mRecyclerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_main_actv_contact);
        mRecyclerData = new ArrayList<>();
        // Setting the Recycler data.
        recyclerListWithTimelineData();

        mRecyclerAdapter = new RecyclerAdapter(mRecyclerData, this);
        StickyHeaderDecoration decoration = new StickyHeaderDecoration(mRecyclerAdapter);

        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    /**
     * Method to populate data containing TimeLineView drawable and Text into the RecyclerView
     */
    public void recyclerListWithTimelineData() {
        try {
            mRecyclerData.add(new Contact("Cyril", "1232354234", "c@n.com", "invited", false));
            mRecyclerData.add(new Contact("Anisa", "1232354234", "a@n.com", "invited", false));
            mRecyclerData.add(new Contact("Akash", "1232354234", "c@n.com", "invited", false));
            mRecyclerData.add(new Contact("Ayeshu", "1232354234", "c@n.com", "invited", true));
            mRecyclerData.add(new Contact("Bhanu", "1232354234", "c@n.com", "invited", false));
            mRecyclerData.add(new Contact("Sahil", "1232354234", "c@n.com", "invited", true));
            mRecyclerData.add(new Contact("Bhavesh", "1232354234", "c@n.com", "invited", false));
            mRecyclerData.add(new Contact("Kalyan", "1232354234", "c@n.com", "invited", false));

        } catch (NullPointerException nPE) {
            nPE.printStackTrace();
        } catch (Resources.NotFoundException nFE) {
            nFE.printStackTrace();
        }
    }
}

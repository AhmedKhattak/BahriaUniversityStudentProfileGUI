package com.example.ahmed.redux.Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmed.redux.Adapters.AttendenceAdapter;
import com.example.ahmed.redux.Adapters.ExamSeatingPlanAdapter;
import com.example.ahmed.redux.Models.Attendence;
import com.example.ahmed.redux.Providers.AttendenceProvider;
import com.example.ahmed.redux.Providers.ExamSeatingPlanProvider;
import com.example.ahmed.redux.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by Ahmed on 7/17/2016.
 */
public class Fragment3 extends Fragment{

    private RecyclerView recyclerView;
    private AttendenceAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.RecycledViewPool recycledViewPool;
    List<Attendence> attendences=new ArrayList<>();


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view3);
        mAdapter=new AttendenceAdapter(attendences,getActivity());
        recycledViewPool=new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,15);
        mLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 3200;
            }
        };
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setRecycledViewPool(recycledViewPool);
        recyclerView.setAdapter(mAdapter);
        attendences=AttendenceProvider.getAttendenceList();

        for(int x=0;x<attendences.size();x++)
        {
            mAdapter.add(attendences.get(x),x);
        }

        //recyclerView.scrollToPosition(0);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }

}

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

import com.example.ahmed.redux.Adapters.ExamSeatingPlanAdapter;
import com.example.ahmed.redux.Providers.ExamSeatingPlanProvider;
import com.example.ahmed.redux.R;

import java.util.ArrayList;

/**
 * Created by KhattaK on 7/14/2016.
 */
public class Fragment2 extends Fragment {

    private RecyclerView recyclerView;
    private ExamSeatingPlanAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.RecycledViewPool recycledViewPool;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view2);
        mAdapter=new ExamSeatingPlanAdapter(ExamSeatingPlanProvider.getExamSeatingPlanData());
        mLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 3000;
            }
        };
        recycledViewPool=new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,15);
        recycledViewPool.setMaxRecycledViews(1,15);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setRecycledViewPool(recycledViewPool);
        recyclerView.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }
}

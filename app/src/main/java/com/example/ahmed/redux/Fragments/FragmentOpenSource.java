package com.example.ahmed.redux.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmed.redux.Interfaces.Comm;
import com.example.ahmed.redux.R;

/**
 * Created by Khattak on 7/28/2016.
 */
public class FragmentOpenSource extends Fragment {

    Comm com;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        com=(Comm)context;
        com.Fuck("c_open");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        com=null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //setHasOptionsMenu(true);
        return inflater.inflate(R.layout.settings_layout_fragment_opensource, container, false);
    }
}

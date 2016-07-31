package com.example.ahmed.redux.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ahmed.redux.R;

/**
 * Created by Khattak on 7/30/2016.
 */
public class opensource  extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opensource);
        toolbar = (Toolbar) findViewById(R.id.toolbarr);
        toolbar.setTitle("Privacy Policy");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        toolbar=null;
    }
}

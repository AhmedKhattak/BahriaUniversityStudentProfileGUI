package com.example.ahmed.redux.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmed.redux.R;

/**
 * Created by Khattak on 8/10/2016.
 */
public class ProfileActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    LinearLayout linearLayout;
    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = (Toolbar) findViewById(R.id.toolbarp);
        toolbar.setTitle("Profile");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        linearLayout=(LinearLayout)findViewById(R.id.passwordchange);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(ProfileActivity.this)
                        .title("Change Password")
                        .customView(R.layout.dialog_change_password, true)
                        .positiveText("Change Password")
                        .negativeText("Go Back")
                        .show();
            }
        });
        textView=(TextView)findViewById(R.id.buemailpass);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(ProfileActivity.this)
                        .title("BU Email Password")
                        .customView(R.layout.dialog_bu_email_password_view, true)
                        .positiveText("DONE")
                        .show();
            }
        });

        textView2=(TextView)findViewById(R.id.buemailpassagain);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(ProfileActivity.this)
                        .title("BU Email Password")
                        .customView(R.layout.dialog_bu_email_password_view, true)
                        .positiveText("DONE")
                        .show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toolbar=null;
        fab.setOnClickListener(null);
        fab=null;
        linearLayout.setOnClickListener(null);
        textView.setOnClickListener(null);
        textView2.setOnClickListener(null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("Fuck", "sht");
                finish();
               // overridePendingTransition(R.anim.nothing,R.anim.test4);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        Log.d("Fuck", "sht");
        finish();
        //overridePendingTransition(R.anim.nothing,R.anim.test4);
    }
}

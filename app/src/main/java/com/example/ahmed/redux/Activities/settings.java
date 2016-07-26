package com.example.ahmed.redux.Activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmed.redux.R;

public class settings extends AppCompatActivity {

    private AppCompatActivity appCompatActivity;
    private  Toolbar toolbar;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;
    private RelativeLayout relativeLayout3;
    private CheckBox checkBox;
    private SwitchCompat switchCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        appCompatActivity=this;
        toolbar = (Toolbar) findViewById(R.id.toolbarr);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpFromSameTask(appCompatActivity);
            }
        });
        relativeLayout1=(RelativeLayout)findViewById(R.id.r1);
        relativeLayout2=(RelativeLayout)findViewById(R.id.r2);
        relativeLayout3=(RelativeLayout)findViewById(R.id.r3);
        checkBox=(CheckBox)findViewById(R.id.checkbox1);
        switchCompat=(SwitchCompat)findViewById(R.id.switcher);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new MaterialDialog.Builder(appCompatActivity)
                        .title("Sync Intervals")
                        .items(R.array.listArray)
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                /**
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 **/
                                return true;
                            }
                        })
                        .positiveText("Set")
                        .show();
            }
        });

        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox.isChecked())
                checkBox.setChecked(false);
                else
                {
                    checkBox.setChecked(true);
                }
            }
        });

        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(switchCompat.isChecked())
                switchCompat.setChecked(false);
                else{
                    switchCompat.setChecked(true);
                }
            }
        });





    }
}

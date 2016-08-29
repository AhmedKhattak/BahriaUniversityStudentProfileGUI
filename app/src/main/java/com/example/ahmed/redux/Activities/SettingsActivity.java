package com.example.ahmed.redux.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmed.redux.Adapters.SettingsAdapter;
import com.example.ahmed.redux.Providers.Settings_Provider;
import com.example.ahmed.redux.R;

public class SettingsActivity extends AppCompatActivity implements SettingsAdapter.ClickListener {
    private Handler mHandler = new Handler();
    private Runnable mUpdateTimeTask;
    private RecyclerView recyclerView;
    private SettingsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private Toolbar toolbar;


    @Override
    protected void onDestroy() {
        //remove references so gc can do its shit
        super.onDestroy();
        toolbar = null;
        mUpdateTimeTask = null;
        recyclerView = null;
        mAdapter = null;
        mLayoutManager = null;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        toolbar = (Toolbar) findViewById(R.id.toolbarr);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mUpdateTimeTask = new Runnable() {
            public void run() {
                // do what you need to do here after the delay
                /*getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right_with_fadein, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.roooot, new FragmentPrivacyPolicy(), "Fragment_PrivacyPolicy")
                        .addToBackStack(null)
                        .commit();
                toolbar.setTitle("Privacy Policy");*/
            }
        };
        recyclerView = (RecyclerView) findViewById(R.id.settingsrecyclerview);
        mAdapter = new SettingsAdapter(Settings_Provider.getSettingsData(), this, getResources().getColor(R.color.secondary_text));
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //mAdapter.setHasStableIds(true);
        mAdapter.SetClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    /*@Override
    public void Fuck(String shat) {

        if (shat == "privacy") {

            mHandler.postDelayed(mUpdateTimeTask, 80);
        } else if (shat == "license") {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right_with_fadein, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.roooot, new FragmentOpenSource(), "Fragment_OpenSource")
                    .addToBackStack(null)
                    .commit();
            toolbar.setTitle("Open Source Licenses");

        } else if (shat == "c_settings") {
            toolbar.setTitle("Settings");
        }

    }*/

    @Override
    public void ItemClicked(View view, int position, Object object) {
        if (object instanceof SettingsAdapter.settings_view_switch) {
            SettingsAdapter.settings_view_switch settings_view_switch = (SettingsAdapter.settings_view_switch) object;
            if (settings_view_switch.heading.getText() == "Notifications") {
                if (settings_view_switch.switchCompat.isChecked()) {
                    settings_view_switch.switchCompat.setChecked(false);
                    settings_view_switch.summary.setText("Disabled");
                } else {
                    settings_view_switch.switchCompat.setChecked(true);
                    settings_view_switch.summary.setText("Enabled");
                }
            }
        } else if (object instanceof SettingsAdapter.settings_view_default) {
            final SettingsAdapter.settings_view_default settings_view_default = (SettingsAdapter.settings_view_default) object;

            if (settings_view_default.heading.getText() == "Change Log") {
                new MaterialDialog.Builder(this)
                        .title("Change Log")
                        .content("Made the app more smoother and  sexier heuheuehuehuheu :P\n")
                        .show();
            } else if (settings_view_default.heading.getText() == "Background Sync") {
                new MaterialDialog.Builder(this)
                        .title("Background Sync Intervals")
                        .items(R.array.listArray)
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                //idher set kar pref ko
                                settings_view_default.summary.setText(text);
                                return true;
                            }
                        })
                        .positiveText("Set")
                        .show();
            } else if (settings_view_default.heading.getText() == "Privacy Policy") {

                Intent i = new Intent(this, PrivacyPolicyActivity.class);
                startActivity(i);
                //overridePendingTransition(R.anim.Animation_2,android.R.anim.fade_out);
            } else if (settings_view_default.heading.getText() == "Open Source") {
                Intent i = new Intent(this, OpenSourceActivity.class);
                startActivity(i);
                //overridePendingTransition(R.anim.Animation_2,android.R.anim.fade_out);
            } else if (settings_view_default.heading.getText() == "Build Version") {
                //NothingAnim pata nae shaid kuch daldon aween me
            } else if (settings_view_default.heading.getText() == "About") {
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("Fuck", "sht");
                finish();
                //overridePendingTransition(R.anim.NothingAnim,R.anim.Animation_4);
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
        //overridePendingTransition(R.anim.NothingAnim,R.anim.Animation_4);
    }


}

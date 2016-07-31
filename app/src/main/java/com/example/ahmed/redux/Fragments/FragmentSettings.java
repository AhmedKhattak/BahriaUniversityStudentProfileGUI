package com.example.ahmed.redux.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmed.redux.Adapters.SettingsAdapter;
import com.example.ahmed.redux.Interfaces.Comm;
import com.example.ahmed.redux.Providers.Settings_Provider;
import com.example.ahmed.redux.R;

/**
 * Created by Khattak on 7/28/2016.
 */
public class FragmentSettings extends android.support.v4.app.Fragment implements  SettingsAdapter.ClickListener{



    private RecyclerView recyclerView;
    private SettingsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    Comm com;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        com=(Comm)context;
        com.Fuck("c_settings");

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        recyclerView=null;
        mAdapter=null;
        mLayoutManager=null;
        com=null;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       /* toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.Fuck("Settings");
            }
        });*/
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.settingsrecyclerview);
        mAdapter = new SettingsAdapter(Settings_Provider.getSettingsData(), getActivity(), getResources().getColor(R.color.secondary_text));
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //mAdapter.setHasStableIds(true);
        mAdapter.SetClickListener(this);
        recyclerView.setAdapter(mAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.settings_fragment_main, container, false);
    }

    @Override
    public void ItemClicked(View view, int position, Object object) {
        if (object instanceof SettingsAdapter.settings_view_switch) {
            SettingsAdapter.settings_view_switch settings_view_switch = (SettingsAdapter.settings_view_switch) object;
            if (settings_view_switch.heading.getText() == "Notifications") {
                if(settings_view_switch.switchCompat.isChecked()) {
                    settings_view_switch.switchCompat.setChecked(false);
                    settings_view_switch.summary.setText("Disabled");
                }
                else{
                    settings_view_switch.switchCompat.setChecked(true);
                    settings_view_switch.summary.setText("Enabled");
                }
            }
        } else if (object instanceof SettingsAdapter.settings_view_default) {
            final SettingsAdapter.settings_view_default settings_view_default = (SettingsAdapter.settings_view_default) object;

            if (settings_view_default.heading.getText() == "Change Log") {
                new MaterialDialog.Builder(getActivity())
                        .title("Change Log")
                        .content("Made the app more smoother and  sexier heuheuehuehuheu :P\n")
                        .show();
            } else if (settings_view_default.heading.getText() == "Background Sync") {
                new MaterialDialog.Builder(getActivity())
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
            } /*else if (settings_view_default.heading.getText() == "File Save Location") {
                new FolderChooserDialog.Builder(this)
                        .chooseButton(R.string.md_choose_label)  // changes label of the choose button
                        .initialPath("/sdcard/Download")  // changes initial path, defaults to external storage directory
                        .tag("optional-identifier")
                        .show();
                Toast.makeText(this, "File Save Location", Toast.LENGTH_SHORT).show();
            } */else if (settings_view_default.heading.getText() == "Privacy Policy") {
               /* new MaterialDialog.Builder(this)
                        .title("Privacy Policy")
                        .customView(R.layout.privacypolicy, false)
                        .positiveText("Accept")
                        .show();*/

                com.Fuck("privacy");
            } else if (settings_view_default.heading.getText() == "Open Source") {
                com.Fuck("license");
            } else if (settings_view_default.heading.getText()== "Build Version") {
                //nothing pata nae shaid kuch daldon aween me
            }
        }
    }
}

package com.example.ahmed.redux.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ahmed.redux.Models.Settings_Model_Checkbox;
import com.example.ahmed.redux.Models.Settings_Model_Default;
import com.example.ahmed.redux.Models.Settings_Model_Switch;
import com.example.ahmed.redux.R;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.List;

/**
 * Created by Khattak on 7/26/2016.
 */
public class SettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public List<Object> objectList;
    private final int DEFAULT = 0, CHECKBOX = 1, SWITCH = 2;
    Context context;
    int color;
    private ClickListener clickListener;

    public SettingsAdapter(List<Object> objectList, Context context, int color) {
        this.objectList = objectList;
        this.context = context;
        this.color = color;
    }


    @Override
    public int getItemViewType(int position) {

        if (objectList.get(position) instanceof Settings_Model_Default) {
            return DEFAULT;
        } else if (objectList.get(position) instanceof Settings_Model_Checkbox) {
            return CHECKBOX;
        } else if (objectList.get(position) instanceof Settings_Model_Switch) {
            return SWITCH;
        } else {
            return -1;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case DEFAULT:
                View v1 = inflater.inflate(R.layout.settings_view_default, parent, false);
                viewHolder = new settings_view_default(v1);
                break;
            case SWITCH:
                View v2 = inflater.inflate(R.layout.settings_view_switch, parent, false);
                viewHolder = new settings_view_switch(v2);
                break;
            case CHECKBOX:
                View v3 = inflater.inflate(R.layout.settings_view_checkbox, parent, false);
                viewHolder = new settings_view_checkbox(v3);
                break;
        }
        return viewHolder;
    }


    /**
     * idher shared pref se data nikalta hai binding ke waqt phir elseifs me jakay nikalta hai idher save nae krna kuch bhi
     * save actitivty se krna hai
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        switch (holder.getItemViewType()) {
            case DEFAULT:
                settings_view_default vh1 = (settings_view_default) holder;
                Settings_Model_Default settings_model_default = (Settings_Model_Default) objectList.get(position);
                vh1.heading.setText(settings_model_default.getHeader());
                vh1.summary.setText(settings_model_default.getSummary());
                if (settings_model_default.getHeader() == "Change Log") {
                    vh1.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_note_text)
                            .color(color)
                            .sizeDp(24));
                } else if (settings_model_default.getHeader() == "Background Sync") {
                    vh1.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_refresh)
                            .color(color)
                            .sizeDp(24));
                    //ider summary change karni
                }
                else if (settings_model_default.getHeader() == "Privacy Policy") {
                    vh1.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_shield)
                            .color(color)
                            .sizeDp(24));
                } else if (settings_model_default.getHeader() == "Open Source") {
                    vh1.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_gavel)
                            .color(color)
                            .sizeDp(24));
                } else if (settings_model_default.getHeader() == "Build Version") {
                    vh1.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_android)
                            .color(color)
                            .sizeDp(24));
                }else if(settings_model_default.getHeader()=="About")
                {
                    vh1.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_information)
                            .color(color)
                            .sizeDp(24));
                }
                break;
            case CHECKBOX:
                final settings_view_checkbox vh2 = (settings_view_checkbox) holder;
                Settings_Model_Checkbox settings_model_checkbox = (Settings_Model_Checkbox) objectList.get(position);
                vh2.heading.setText(settings_model_checkbox.getHeader());
                vh2.summary.setText(settings_model_checkbox.getSummary());
                /*vh2.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(vh2.checkBox.isChecked())
                            vh2.checkBox.setChecked(false);
                        else
                        {
                            vh2.checkBox.setChecked(true);
                        }
                    }
                });*/

                break;

            case SWITCH:
                settings_view_switch vh3 = (settings_view_switch) holder;
                Settings_Model_Switch settings_model_switch = (Settings_Model_Switch) objectList.get(position);
                vh3.heading.setText(settings_model_switch.getHeader());
                vh3.summary.setText(settings_model_switch.getSummary());
                if (settings_model_switch.getHeader() == "Notifications") {
                    vh3.imageView.setImageDrawable(new IconicsDrawable(context)
                            .icon(CommunityMaterial.Icon.cmd_bell_ring)
                            .color(color)
                            .sizeDp(24));
                    //ider summary badalni
                }
                break;

        }

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public static class settings_view_checkbox extends RecyclerView.ViewHolder {

        public TextView heading, summary;
        public CheckBox checkBox;
        //public RelativeLayout relativeLayout;

        public settings_view_checkbox(View itemView) {
            super(itemView);
            heading = (TextView) itemView.findViewById(R.id.Heading);
            summary = (TextView) itemView.findViewById(R.id.Summary);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_);
            //relativeLayout=(RelativeLayout)itemView.findViewById(R.id.r2);
        }
    }

    public  class settings_view_default extends RecyclerView.ViewHolder implements  View.OnClickListener{

        public TextView heading, summary;
        //public RelativeLayout relativeLayout;
        public ImageView imageView;

        public settings_view_default(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            heading = (TextView) itemView.findViewById(R.id.Heading);
            summary = (TextView) itemView.findViewById(R.id.Summary);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            //relativeLayout=(RelativeLayout)itemView.findViewById(R.id.r1);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.ItemClicked(view,getAdapterPosition(),this);
            }
        }
    }

    public  class settings_view_switch extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView heading, summary;
        public SwitchCompat switchCompat;
        // public RelativeLayout relativeLayout;
        public ImageView imageView;

        public settings_view_switch(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            heading = (TextView) itemView.findViewById(R.id.Heading);
            summary = (TextView) itemView.findViewById(R.id.Summary);
            switchCompat = (SwitchCompat) itemView.findViewById(R.id.switcher);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            // relativeLayout=(RelativeLayout)itemView.findViewById(R.id.r3);
        }


        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.ItemClicked(view,getAdapterPosition(),this);
            }

        }
    }

    public void SetClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void ItemClicked(View view, int position,Object object);
    }

}

package com.example.ahmed.redux.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmed.redux.Models.NavItems_Header_Model;
import com.example.ahmed.redux.Models.NavItems_Model;
import com.example.ahmed.redux.R;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.List;


/**
 * Created by Ahmed Khattak on 02/08/2016.
 */
public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.ViewHolder> {
    static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    private static final int TYPE_ITEM = 1;
    public Context context;
    int color;
    private String name;        //String Resource for header View Name
    private int profile;        //int Resource for header view profile picture
    private String enrollment;       //String Resource for header view enrollment
    public List<Object> navItemsModelList;
    int size=20;


    public NavDrawerAdapter(Context context, List<Object> navItemsModelList, int color) {

        this.context = context;
        this.navItemsModelList = navItemsModelList;
        this.color = color;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrow, parent, false); //Inflating the layout
            ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view
            return vhItem;

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navdrawer_header, parent, false); //Inflating the layout
            ViewHolder vhHeader = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view
            return vhHeader;

        }
        return null;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.Holderid == 1) {
            NavItems_Model navItems_model =(NavItems_Model) navItemsModelList.get(position);
            holder.textView.setText(navItems_model.getId());
            if (navItems_model.getId() == "Profile") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_user)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Evaluation") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_refresh)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Registration") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_pencil_square)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Change Password") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_key)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Notifications") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_bell)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Settings") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_cog)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Feedback") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_commenting)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Rate Us !") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_bullhorn)
                        .color(color)
                        .sizeDp(size));

            } else if (navItems_model.getId() == "Privacy Policy") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_user_secret)
                        .color(color)
                        .sizeDp(size));
            }
            else if (navItems_model.getId() == "Logout") {
                holder.imageView.setImageDrawable(new IconicsDrawable(context)
                        .icon(FontAwesome.Icon.faw_sign_out)
                        .color(color)
                        .sizeDp(size));
            }
        } else {

            NavItems_Header_Model navItems_header_model=(NavItems_Header_Model)navItemsModelList.get(position);
            holder.profile.setImageResource(navItems_header_model.getProfile());           // Similarly we set the resources for header view
            holder.Name.setText(navItems_header_model.getName());
            holder.enroll.setText(navItems_header_model.getEnroll());
        }
    }

    @Override
    public int getItemCount() {
        return navItemsModelList.size();
    }


    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView enroll;


        public ViewHolder(View itemView, int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);


            // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

            if (ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
                Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row
            } else {


                Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from header.xml for name
                enroll = (TextView) itemView.findViewById(R.id.enroll);       // Creating Text View object from header.xml for enrollment
                profile = (ImageView) itemView.findViewById(R.id.userimage);// Creating Image view object from header.xml for profile pic
                Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
            }
        }


    }
}

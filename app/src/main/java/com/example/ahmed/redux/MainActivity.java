package com.example.ahmed.redux;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmed.redux.Activities.FeedBackActivity;
import com.example.ahmed.redux.Activities.ProfileActivity;
import com.example.ahmed.redux.Activities.settings;
import com.example.ahmed.redux.Adapters.NavDrawerAdapter;
import com.example.ahmed.redux.Fragments.Fragment1;
import com.example.ahmed.redux.Fragments.Fragment2;
import com.example.ahmed.redux.Fragments.Fragment3;
import com.example.ahmed.redux.Providers.NavDrawerItemProvider;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialize.Materialize;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavDrawerAdapter.ClickListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String NAME = "Ahmed Khattak";
    String ENROLL = "01-134132-016";
    int PROFILE = R.drawable.aka;
    //String appPackageName = getPackageName();

    /* RecyclerView mRecyclerView;                           // Declaring RecyclerView
     NavDrawerAdapter mAdapter;                        // Declaring Adapter For Recycler View
     RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
     DrawerLayout Drawer;                                  // Declaring DrawerLayout*/
   /* ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle*/
    /*@Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MyMaterialThemezzz);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

       /* mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new NavDrawerAdapter(this, NavDrawerItemProvider.getExamSeatingPlanData(),getResources().getColor(R.color.secondary_text));
        mAdapter.SetClickListener(this);
        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager




        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

        };


        Drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State*/

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withSelectionListEnabledForSingleProfile(false)
                .withActivity(this)
                .withHeaderBackground(R.drawable.w1)
                .addProfiles(
                        new ProfileDrawerItem().withName("Ahmed Khattak").withEmail("01-134132-016").withIcon(getResources().getDrawable(R.drawable.aka))

                ).withAlternativeProfileHeaderSwitching(false)
                .build();


        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Profile").withIcon(CommunityMaterial.Icon.cmd_account);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withName("Notifications").withBadge("19").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.primary)).withIcon(CommunityMaterial.Icon.cmd_bell_ring);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(1).withName("Evaluation").withIcon(CommunityMaterial.Icon.cmd_format_list_bulleted);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(1).withName("Registration").withIcon(CommunityMaterial.Icon.cmd_border_color);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(1).withName("Settings").withIcon(CommunityMaterial.Icon.cmd_settings);
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(1).withName("Rate Us !").withIcon(CommunityMaterial.Icon.cmd_bullhorn);
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(1).withName("Feedback").withIcon(CommunityMaterial.Icon.cmd_comment_processing);
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(1).withName("Logout").withIcon(CommunityMaterial.Icon.cmd_logout_variant);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        new DividerDrawerItem(),
                        item5,
                        item6,
                        item7, item8
                )
                .withAccountHeader(headerResult)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if(position==1)
                        {
                            // User chose the "tabdownload" action open modal or something
                            Intent j = new Intent(MainActivity.this, ProfileActivity.class);
                            startActivity(j);
                            //overridePendingTransition(R.anim.test3, android.R.anim.fade_out);
                        }
                        else if(position==2)
                        {

                        }
                        else if(position==3)
                        {

                        }
                        else if(position==4)
                        {

                        }
                        else if(position==5)
                        {

                        }
                        else if(position==6)
                        {
                            Intent i = new Intent(MainActivity.this, settings.class);
                            startActivity(i);
                            //overridePendingTransition(R.anim.test3, android.R.anim.fade_out);
                        }
                        else if(position==7)
                        {
                             // getPackageName() from Context or Activity object
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +"com.bu.innovate.bustudentportal" )));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" +"com.bu.innovate.bustudentportal" )));
                            }
                        }
                        else if(position==8)
                        {
                            Intent i = new Intent(MainActivity.this, FeedBackActivity.class);
                            startActivity(i);
                        }
                        else if(position==9)
                        {

                        }
                        else if(position==10)
                        {

                        }
                        return true;
                    }
                }).withActionBarDrawerToggleAnimated(true).withSelectedItem(-1).withDelayOnDrawerClose(-1)
                .build();


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                /*Toast.makeText(this, "Settings clicked !", Toast.LENGTH_SHORT).show();*/
                Intent i = new Intent(this, settings.class);
                startActivity(i);
                //overridePendingTransition(R.anim.test3, android.R.anim.fade_out);
                return true;


            case R.id.overflow:
                // User chose the "tabdownload" action open modal or something
                //Toast.makeText(this, "overflow c clicked !", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.refresh:
                // User chose the "tabdownload" action open modal or something
                Toast.makeText(this, "refresh clicked !", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private void setupTabIcons() {

        tabLayout.getTabAt(0).setIcon(new IconicsDrawable(this)
                .icon(CommunityMaterial.Icon.cmd_account_check)
                .color(Color.WHITE)
                .sizeDp(21));
        tabLayout.getTabAt(1).setIcon(new IconicsDrawable(this)
                .icon(CommunityMaterial.Icon.cmd_calendar_clock)
                .color(Color.WHITE)
                .sizeDp(21));
        tabLayout.getTabAt(2).setIcon(new IconicsDrawable(this)
                .icon(CommunityMaterial.Icon.cmd_format_list_bulleted_type)
                .color(Color.WHITE)
                .sizeDp(21));

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment3(), "ONE");
        adapter.addFragment(new Fragment2(), "TWO");
        adapter.addFragment(new Fragment1(), "THREE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void ItemClicked(View view, int position, Object object) {
        if (position == 1) {
            // User chose the "tabdownload" action open modal or something
            Intent j = new Intent(this, ProfileActivity.class);
            startActivity(j);
            overridePendingTransition(R.anim.test3, android.R.anim.fade_out);
        } else if (position == 6) {
            Intent i = new Intent(this, settings.class);
            startActivity(i);
            overridePendingTransition(R.anim.test3, android.R.anim.fade_out);
        }
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        setupViewPager(viewPager);
        setupTabIcons();
    }
}

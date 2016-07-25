package com.example.ahmed.redux;

import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.ahmed.redux.Activities.settings;
import com.example.ahmed.redux.Fragments.Fragment1;
import com.example.ahmed.redux.Fragments.Fragment2;
import com.example.ahmed.redux.Fragments.Fragment3;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private Toolbar toolbar;
    private TabLayout tabLayout;



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);




    }

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MyMaterialThemezzz);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

       /* setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();*/
       /* AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.w1)
                .withSelectionListEnabledForSingleProfile(false)
                .addProfiles(
                        new ProfileDrawerItem().withName("Ahmed Rafiullah").withEmail("01-134132-016").withIcon(R.drawable.aka)
                )
                .build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Notifications").withIcon(FontAwesome.Icon.faw_bell).withBadge("22").withBadgeStyle(new BadgeStyle(Color.RED, Color.RED).withTextColor(Color.WHITE)).withIdentifier(1);
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(headerResult)
                .addDrawerItems(new PrimaryDrawerItem().withName("Personal Info").withIcon(FontAwesome.Icon.faw_user).withIdentifier(2), item1,
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Settings").withIcon(FontAwesome.Icon.faw_cog).withIdentifier(3),
                        new SecondaryDrawerItem().withName("Help").withIcon(FontAwesome.Icon.faw_question).withIdentifier(4),
                        new SecondaryDrawerItem().withName("Open Source").withIcon(FontAwesome.Icon.faw_github).withIdentifier(5),
                        new SecondaryDrawerItem().withName("Contact").withIcon(FontAwesome.Icon.faw_bullhorn).withIdentifier(6),
                        new SecondaryDrawerItem().withName("About").withIcon(FontAwesome.Icon.faw_info).withIdentifier(7),
                        new SecondaryDrawerItem().withName("Sign Out").withIcon(FontAwesome.Icon.faw_sign_out).withIdentifier(8))
                .withSelectedItem(-1)
                .build();
*/
        //endregion



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
                return true;

            case R.id.tabdownload:
                // User chose the "tabdownload" action open modal or something
                Toast.makeText(this, "Download tab clicked !", Toast.LENGTH_SHORT).show();
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
}

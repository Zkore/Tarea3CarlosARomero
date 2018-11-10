package com.iteso.tarea3carlosaromero;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import beans.FragmentElectronics;
import beans.FragmentHome;
import beans.FragmentTechnology;
import tools.Commons;

public class activity_main extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager =  findViewById(R.id.container);
        viewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case Commons.IDX_SECTION1:
                    return new FragmentTechnology();
                case Commons.IDX_SECTION2:
                    return new FragmentHome();
                case Commons.IDX_SECTION3:
                    return new FragmentElectronics();
                default:
                    return new FragmentElectronics();
            }
        }

        @Override
        public int getCount() {
            return Commons.PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case Commons.IDX_SECTION1: return getString(R.string.section1);
                case Commons.IDX_SECTION2: return getString(R.string.section2);
                case Commons.IDX_SECTION3: return getString(R.string.section3);
            }
            return null;
        }
    }
}

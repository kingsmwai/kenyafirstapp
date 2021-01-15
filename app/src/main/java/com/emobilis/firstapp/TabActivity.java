package com.emobilis.firstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    //declare a subclass adapter class
    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //view identification
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getmenu
        getMenuInflater().inflate(R.menu.bottom_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_toast){
            Toast.makeText(this, "On options item selected menu works", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //place holder fragment
    public static class PlaceholderFragment extends Fragment{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        //empty constructor
        public PlaceholderFragment() {
        }

        //new instances of fragments according to position
        public static PlaceholderFragment newInstance(int sectionNumber){
            //create the new object
            PlaceholderFragment placeholderFragment = new PlaceholderFragment();
            //bundle instance
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER,sectionNumber);
            placeholderFragment.setArguments(args);
            return  placeholderFragment;
        }

        @SuppressLint("StringFormatInvalid")
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View rootview = inflater.inflate(R.layout.fragment_main,container,false);
                TextView textView = rootview.findViewById(R.id.textTitle);
                textView.setText(getString(R.string.section_format,getArguments().getInt(ARG_SECTION_NUMBER)));
                return rootview;
        }
    }

    //subclass SectionsPagerAdapter
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        //constructor
        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //check if any fragment is loaded
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new Fragment_A();
                    break;
                case 1:
                    fragment = new Fragment_B();
                    break;
                case 2:
                    fragment = new Fragment_C();
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        //giving fragments page titles

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Fragment A";
                case 1:
                    return "Fragment B";
                case 2:
                    return "Fragment C";
            }
            return null;
        }
    }
}

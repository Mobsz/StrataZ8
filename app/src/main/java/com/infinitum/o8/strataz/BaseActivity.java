package com.infinitum.o8.strataz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ShareActionProvider;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class BaseActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;
    public TextView woodResourceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Attach the SectionsPagerAdapter to the ViewPager
        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pagerView);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        //sets the opening tab, current topfragment "Home" tab
        pager.setCurrentItem(3);

    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RuleFragment();
                case 1:
                    return new ResourceFragment();
                case 2:
                    return new HomeFragment();
                case 3:
                    return new TopFragment();
                case 4:
                    return new UnitFragment();
                case 5:
                    return new DiceFragment();
                case 6:
                    return new DrawCardFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 1:
                    return getResources().getText(R.string.resource_tab);
                case 2:
                    return getResources().getText(R.string.home_tab);
                case 4:
                    return getResources().getText(R.string.unit_tab);
                case 5:
                    return getResources().getText(R.string.dice_tab);
                case 0:
                    return "Rules";
                case 6:
                    return "SP Cards";
                case 3:
                    return "Top";
            }
            return null;
        }
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }


//Draw Card Fragment onClick Method
    public void onClickDraw(View view) {
        //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();

        TextView spNameView = findViewById(R.id.spNameView);
        TextView spInfo = findViewById(R.id.spInfoView);
        TextView spBlurb = findViewById(R.id.spBlurbView);
        ImageView spImage = findViewById(R.id.spImageView);

        Random rand = new Random();
        int x = rand.nextInt(3);
        switch (x) {
            case 0:
                spNameView.setText("Blahsda");
                spInfo.setText("safsaf");
                spBlurb.setText("23as");
                spImage.setImageResource(R.drawable.warrior_unit);
                break;
            case 1:
                spNameView.setText("Bla htdujhe a");
                spInfo.setText("sh arrs h");
                spBlurb.setText("df ghd he");
                spImage.setImageResource(R.drawable.archer_unit);
                break;
            case 2:
                spNameView.setText("Bfdhfdsha");
                spInfo.setText("r eye rh");
                spBlurb.setText("23 reer ");
                spImage.setImageResource(R.drawable.wheat_resource);
                break;
        }


    }
}
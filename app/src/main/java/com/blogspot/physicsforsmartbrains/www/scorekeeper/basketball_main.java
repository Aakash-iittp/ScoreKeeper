package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class basketball_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_main);

        ViewPager basketballViewPager = (ViewPager) findViewById(R.id.basketball_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        BasketballSimpleFragmentPagerAdapter adapter = new BasketballSimpleFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        basketballViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.basketball_sliding_tabs);
        tabLayout.setupWithViewPager(basketballViewPager);

    }
}

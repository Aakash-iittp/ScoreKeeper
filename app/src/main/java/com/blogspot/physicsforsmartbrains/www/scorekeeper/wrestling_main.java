package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class wrestling_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrestling_main);

        ViewPager basketballViewPager = (ViewPager) findViewById(R.id.w_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        WrestlingSimpleFragmentPagerAdapter adapter = new WrestlingSimpleFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        basketballViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.w_sliding_tabs);
        tabLayout.setupWithViewPager(basketballViewPager);
    }
}

package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by HP Customer on 28-07-2017.
 */

public class TtSimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Rules", "Play", "Timer" };
    private Context context;

    public TtSimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new tabletennis_1_fragment();
        } else if (position == 1){
            return new soccor_2_fragment();
        } else {
            return new badminton_3_fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

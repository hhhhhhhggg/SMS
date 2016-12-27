package com.jfq.msms.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jfq.msms.fragment.Fragment1;
import com.jfq.msms.fragment.Fragment2;
import com.jfq.msms.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016.12.27.
 */

public class MyAdapter extends FragmentPagerAdapter{


    List<Fragment> mFragment;

    public MyAdapter(FragmentManager fm) {
        super(fm);
        mFragment = new ArrayList<Fragment>();
        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
        mFragment.add(new Fragment3());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}

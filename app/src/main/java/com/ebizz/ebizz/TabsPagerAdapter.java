package com.ebizz.ebizz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

public class TabsPagerAdapter  extends FragmentStatePagerAdapter {

    private int TOTAL_TABS = 5;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        if(index<TOTAL_TABS){
            switch (index) {
                case 0:
                    return new BusinessFragment();
                case 1:
                    return new BusinessFragment();
                case 2:
                    return new BusinessIndexable();
                case 3:
                    return new BusinessIndexable();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TOTAL_TABS;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        FragmentManager manager = ((Fragment) object).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) object);
        trans.commit();

        super.destroyItem(container, position, object);
    }
}
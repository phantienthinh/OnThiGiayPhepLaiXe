package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.onthi.laixe.onthigiaypheplaixe.fragments.MeoLyThuyetFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.MeoThucHanhFragment;

public class PagerMeoAdapter extends FragmentStatePagerAdapter {
    public PagerMeoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new MeoLyThuyetFragment();
                break;
            case 1:
                frag = new MeoThucHanhFragment();
                break;

        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String titile = "";
        switch (position) {
            case 0:
                titile = "Mẹo Lý Thuyết";
                break;
            case 1:
                titile = "Mẹo Thực Hành";
                break;
        }
            return titile;
        }

}

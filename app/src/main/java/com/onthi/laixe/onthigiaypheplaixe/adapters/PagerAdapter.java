package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.onthi.laixe.onthigiaypheplaixe.fragments.BaoCamFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.BaoChiDanFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.BaoHieuLenhFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.BaoNguyHiemFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.BaoPhuFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.DuongCaoTocFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.TuyenDuongDoiNgoaiFragment;
import com.onthi.laixe.onthigiaypheplaixe.fragments.VachKeDuongFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new BaoCamFragment();
                break;
            case 1:
                frag = new BaoHieuLenhFragment();
                break;
            case 2:
                frag = new BaoNguyHiemFragment();
                break;
            case 3:
                frag = new BaoPhuFragment();
                break;
            case 4:
                frag = new BaoChiDanFragment();
                break;
            case 5:
                frag = new VachKeDuongFragment();
                break;
            case 6:
                frag = new DuongCaoTocFragment();
                break;
            case 7:
                frag = new TuyenDuongDoiNgoaiFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String titile = "";
        switch (position){
            case 0:
               titile = "Biển Báo Cấm";
                break;
            case 1:
                titile = "Biển Báo Hiệu Lệnh";
                break;
            case 2:
                titile = "Biển Báo Nguy Hiểm";
                break;
            case 3:
                titile = "Biển Báo Phụ";
                break;
            case 4:
                titile = "Biển Báo Chỉ Dẫn";
                break;
            case 5:
                titile = "Vạch Kẻ Đường";
                break;
            case 6:
                titile = "Đường Cao Tốc";
                break;
            case 7:
                titile = "Tuyến Đường Đối Ngoại";
                break;
        }
        return titile;
    }
}

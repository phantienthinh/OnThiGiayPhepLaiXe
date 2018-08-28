package com.onthi.laixe.onthigiaypheplaixe.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.adapters.PagerMeoAdapter;

public class MeoActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager pager;
    private TabLayout tabLayout;
    private PagerMeoAdapter Meoadapter;
    private ImageView iv_back_meo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meo);
        initView();
        addControl();
    }

    private void initView() {
        iv_back_meo = findViewById(R.id.iv_back_meo);
        iv_back_meo.setOnClickListener(this);
    }

    private void addControl() {
        pager = (ViewPager) findViewById(R.id.viewpager_meo);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_meo);
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        FragmentManager manager = getSupportFragmentManager();
        Meoadapter = new PagerMeoAdapter(manager);
        pager.setAdapter(Meoadapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(Meoadapter);//deprecated
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));


        View root = tabLayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.colorPrimary));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(10);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back_meo:
                finish();
                overridePendingTransition(R.anim.anim_start,R.anim.anim_back);
                break;
        }
    }
}

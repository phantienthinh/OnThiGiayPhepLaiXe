package com.onthi.laixe.onthigiaypheplaixe.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.onthi.laixe.onthigiaypheplaixe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeoLyThuyetFragment extends Fragment implements View.OnClickListener {
    private LinearLayout ln_khai_niem,ln_he_thong,ln_sa_hinh;
    private LinearLayout tv_khai_niem,tv_he_thong,tv_sa_hinh;
    private Context context;

    boolean b = false;
    boolean a = false;
    boolean c = false;

    public MeoLyThuyetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meo_ly_thuyet,container,false);
        initView(view);
        return view;
    }

    private void initView(View v) {
        ln_he_thong=v.findViewById(R.id.ln_he_thong);
        ln_khai_niem=v.findViewById(R.id.ln_khai_niem);
        ln_sa_hinh=v.findViewById(R.id.ln_sa_hinh);

        tv_sa_hinh  =v.findViewById(R.id.tv_sa_hinh);
        tv_he_thong =v.findViewById(R.id.tv_he_thong);
        tv_khai_niem=v.findViewById(R.id.tv_khai_niem);


        ln_he_thong .setOnClickListener(this);
        ln_khai_niem.setOnClickListener(this);
        ln_sa_hinh  .setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ln_he_thong:

                if (a==false){
                    a=true;
                    tv_he_thong.setVisibility(View.VISIBLE);
                }else {
                    a=false;
                    tv_he_thong.setVisibility(View.GONE);
                }


                break;
            case R.id.ln_khai_niem:

                if (b==false){
                    b=true;
                    tv_khai_niem.setVisibility(View.VISIBLE);
                }else {
                    b=false;
                    tv_khai_niem.setVisibility(View.GONE);
                }
                break;
            case R.id.ln_sa_hinh:

                if (c==false){
                    c=true;
                    tv_sa_hinh.setVisibility(View.VISIBLE);
                }else {
                    c=false;
                    tv_sa_hinh.setVisibility(View.GONE);
                }
                break;
        }
    }
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }
    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }
}

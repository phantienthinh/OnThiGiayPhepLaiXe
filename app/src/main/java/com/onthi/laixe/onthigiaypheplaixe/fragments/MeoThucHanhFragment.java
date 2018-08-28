package com.onthi.laixe.onthigiaypheplaixe.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeoThucHanhFragment extends Fragment implements View.OnClickListener {
    Context context;
    private LinearLayout ln_gioi_thieu, ln_bai1, ln_bai2, ln_bai3, ln_bai4;
    private TextView tv_gioi_thieu, tv_bai1, tv_bai2, tv_bai3, tv_bai_4;
    boolean a = false, b = false, c = false, d = false, e = false;

    public MeoThucHanhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meo_thuc_hanh, container, false);
        initView(view);
        return view;
    }

    private void initView(View v) {
        ln_gioi_thieu = v.findViewById(R.id.ln_gioi_thieu);
        ln_bai1 = v.findViewById(R.id.ln_bai1);
        ln_bai2 = v.findViewById(R.id.ln_bai2);
        ln_bai3 = v.findViewById(R.id.ln_bai3);
        ln_bai4 = v.findViewById(R.id.ln_bai4);

        tv_gioi_thieu = v.findViewById(R.id.tv_gioi_thieu);
        tv_bai1 = v.findViewById(R.id.tv_bai1);
        tv_bai2 = v.findViewById(R.id.tv_bai2);
        tv_bai3 = v.findViewById(R.id.tv_bai3);
        tv_bai_4 = v.findViewById(R.id.tv_bai4);

        ln_gioi_thieu.setOnClickListener(this);
        ln_bai1.setOnClickListener(this);
        ln_bai2.setOnClickListener(this);
        ln_bai3.setOnClickListener(this);
        ln_bai4.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ln_gioi_thieu:

                if (a == false) {
                    a = true;
                    tv_gioi_thieu.setVisibility(View.VISIBLE);
                } else {
                    a = false;
                    tv_gioi_thieu.setVisibility(View.GONE);
                }
                break;
            case R.id.ln_bai1:

                if (b == false) {
                    b = true;
                    tv_bai1.setVisibility(View.VISIBLE);
                } else {
                    b = false;
                    tv_bai1.setVisibility(View.GONE);
                }
                break;
            case R.id.ln_bai2:

                if (c == false) {
                    c = true;
                    tv_bai2.setVisibility(View.VISIBLE);
                } else {
                    c = false;
                    tv_bai2.setVisibility(View.GONE);
                }
                break;
            case R.id.ln_bai3:

                if (d == false) {
                    d = true;
                    tv_bai3.setVisibility(View.VISIBLE);
                } else {
                    d = false;
                    tv_bai3.setVisibility(View.GONE);
                }
                break;
            case R.id.ln_bai4:

                if (e == false) {
                    e = true;
                    tv_bai_4.setVisibility(View.VISIBLE);
                } else {
                    e = false;
                    tv_bai_4.setVisibility(View.GONE);
                }
                break;
        }
    }
}

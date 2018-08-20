package com.onthi.laixe.onthigiaypheplaixe.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.ScreenSlideActivity;
import com.onthi.laixe.onthigiaypheplaixe.models.Question;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment implements View.OnClickListener {
    ArrayList<Question> arr_ques;
    public static final String ARG_PAGE = "page";
    private int mPageNumber;
    private TextView tvNum, tvQuestion;
    private RadioButton radA, radB, radC, radD;
    private boolean a,b,c,d;
    private RadioGroup radioGroup;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        initView(rootView);

        return rootView;
    }

    private void initView(View group) {
        tvNum = group.findViewById(R.id.tvNum);
        tvQuestion = group.findViewById(R.id.tvQuestion);
        radA = group.findViewById(R.id.radA);
        radB = group.findViewById(R.id.radB);
        radC = group.findViewById(R.id.radC);
        radD = group.findViewById(R.id.radD);
//        radioGroup = group.findViewById(R.id.radGroup);
        radA.setOnClickListener(this);
        radB.setOnClickListener(this);
        radC.setOnClickListener(this);
        radD.setOnClickListener(this);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arr_ques = new ArrayList<Question>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_ques = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu" + (mPageNumber + 1));
        tvQuestion.setText(arr_ques.get(mPageNumber).getCauhoi());
        radA.setText(arr_ques.get(mPageNumber).getAns_a());
        radB.setText(arr_ques.get(mPageNumber).getAns_b());
        radC.setText(arr_ques.get(mPageNumber).getAns_c());
        radD.setText(arr_ques.get(mPageNumber).getAns_d());
        if (arr_ques.get(mPageNumber).getAns_a() == null) {
            radA.setVisibility(View.GONE);
        }
        if (arr_ques.get(mPageNumber).getAns_b() == null) {
            radB.setVisibility(View.GONE);
        }
        if (arr_ques.get(mPageNumber).getAns_c() == null) {
            radC.setVisibility(View.GONE);
        }
        if (arr_ques.get(mPageNumber).getAns_d() == null) {
            radD.setVisibility(View.GONE);
        }



    }

    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radA:
                if (a==false){
                    a=true;
                    radA.setChecked(true);
                }else {
                    a=false;
                    radA.setChecked(false);
                }
                break;

            case R.id.radB:
                if (b==false){
                    b=true;
                    radB.setChecked(true);
                }else {
                    b=false;
                    radB.setChecked(false);
                }
                break;
            case R.id.radC:
                if (c==false){
                    c=true;
                    radC.setChecked(true);
                }else {
                    c=false;
                    radC.setChecked(false);
                }
                break;
            case R.id.radD:
                if (d==false){
                    d=true;
                    radD.setChecked(true);
                }else {
                    d=false;
                    radD.setChecked(false);
                }
                break;
        }
    }
}

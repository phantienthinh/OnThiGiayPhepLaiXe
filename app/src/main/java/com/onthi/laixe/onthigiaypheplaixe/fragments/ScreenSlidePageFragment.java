package com.onthi.laixe.onthigiaypheplaixe.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.activity.ScreenSlideActivity;
import com.onthi.laixe.onthigiaypheplaixe.models.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment implements View.OnClickListener {
    private ImageView iv_icon;
    ArrayList<Question> arr_ques;
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkanswer";
    private int mPageNumber;
    private TextView tvNum, tvQuestion, tv_gt, tv_giai_thich;
    private RadioButton radA, radB, radC, radD;
    private boolean a, b, c, d;
    private RadioGroup radioGroup;
    private String ketQua_A = "0";
    private String ketQua_B = ",0";
    private String ketQua_C = ",0";
    private String ketQua_D = ",0";
    private String ketQua = ",0";
    private BroadcastReceiver receiver;
    private IntentFilter filter;
    public int checkAnswer;
    boolean a1 = false, b1 = false, c1 = false, d1 = false;
    boolean save = false;
    int bc = mPageNumber + 1;
    private Context context;
    private int caudung = 0, causai = 0;
    private String image;

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
        iv_icon = group.findViewById(R.id.ivIcon);
        tv_gt = group.findViewById(R.id.tv_gt);
        tv_giai_thich = group.findViewById(R.id.tv_giai_thich);
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
        //tvTimer.setOnClickListener(this);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arr_ques = new ArrayList<Question>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_ques = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAnswer = getArguments().getInt(ARG_CHECKANSWER);

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

        image = arr_ques.get(mPageNumber).getImage();
        Log.e("111", image + "");
        if (image != null) {
            image = image.replaceAll("jpg", "webp");
            Log.e("1112", image + "");
            loadImageFromAssets();
        }


//        Bitmap bitmap = BitmapFactory.decodeFile("assets/image"+arr_ques.get(mPageNumber).getImage());
//        iv_icon.setImageBitmap(BitmapFactory.decodeFile("assets/image"+arr_ques.get(mPageNumber).getImage()));
//
//        Log.e("qqq", bitmap+"");

        // iv_icon.setImageResource(getResources().getIdentifier(arr_ques.get(mPageNumber).getImage()+"","drawable","com.onthi.laixe.onthigiaypheplaixe"));
        tv_giai_thich.setText(arr_ques.get(mPageNumber).getNote());
//        tv_giai_thich.setVisibility(View.VISIBLE);
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
        if (arr_ques.get(mPageNumber).getImage() == null) {
            iv_icon.setVisibility(View.GONE);
        } else {
            iv_icon.setVisibility(View.VISIBLE);
        }
//        Log.e("abc", save + "");
//        if (save == true) {
//            tv_gt.setVisibility(View.VISIBLE);
//            tv_giai_thich.setVisibility(View.VISIBLE);
//        }
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (intent.getAction()) {
                    case "key_show_text":
                        Log.e("ac", "onReceive: ");
                        tv_gt.setVisibility(View.VISIBLE);
                        tv_giai_thich.setVisibility(View.VISIBLE);
                        radA.setClickable(false);
                        radB.setClickable(false);
                        radC.setClickable(false);
                        radD.setClickable(false);
                        checkKQ(arr_ques.get(mPageNumber).getKetqua().toString());
                        arr_ques.get(mPageNumber).setTra_loi(ketQua);
                        break;
                }
            }
        };
        filter = new IntentFilter();
        filter.addAction("key_show_text");
        context.registerReceiver(receiver, filter);

//        if (checkAnswer != 0) {
//            radA.setClickable(false);
//            radB.setClickable(false);
//            radC.setClickable(false);
//            radD.setClickable(false);
//            checkKQ(arr_ques.get(mPageNumber).getKetqua().toString());
//            Toast.makeText(context, arr_ques.get(mPageNumber).getKetqua().toString(), Toast.LENGTH_LONG).show();
//        }


    }

    private void loadImageFromAssets() {
        // load text
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open(image);
            // load image as Drawable
            Log.e("1114", "deo ok");
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            Log.e("1113", "ok");
            iv_icon.setImageDrawable(d);
        } catch (IOException ex) {
            Log.e("1115", "ok fine");
            return;

        }


    }

    public static ScreenSlidePageFragment create(int pageNumber, int checkanswer) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER, checkanswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radA:
                if (a == false) {
                    a = true;
                    radA.setChecked(true);
                    ketQua_A = "1";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(1, ketQua);
                } else {
                    a = false;
                    radA.setChecked(false);
                    ketQua_A = "0";

                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(1, ketQua);
                }
                break;

            case R.id.radB:
                if (b == false) {
                    b = true;
                    radB.setChecked(true);
                    ketQua_B = ",2";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(2, ketQua);
                } else {
                    b = false;
                    radB.setChecked(false);
                    ketQua_B = ",0";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(2, ketQua);
                }
                break;
            case R.id.radC:
                if (c == false) {
                    c = true;
                    radC.setChecked(true);
                    ketQua_C = ",3";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(3, ketQua);
                } else {
                    c = false;
                    radC.setChecked(false);
                    ketQua_C = ",0";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(3, ketQua);
                }
                break;
            case R.id.radD:
                if (d == false) {
                    d = true;
                    radD.setChecked(true);
                    ketQua_D = ",4";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(4, ketQua);
                } else {
                    d = false;
                    radD.setChecked(false);
                    ketQua_D = ",0";
                    ketQua = ketQua_A + ketQua_B + ketQua_C + ketQua_D;
                    replace();
                    checkChangeRadioButton(4, ketQua);
                }
                break;
        }
    }

    private void checkKQ(String ans) {
//        if (a==true){
//            if (ans.contains("1")==true){
//                a1=true;
//            }else {
//                a1=false;
//            }
//        }
//        if (b==true){
//            if (ans.contains("2")==true){
//                b1=true;
//            }else {
//                b1=false;
//            }
//        }
//        if (c==true){
//            if (ans.contains("3")==true){
//                c1=true;
//            }else {
//                c1=false;
//            }
//        }
//        if (d==true){
//            if (ans.contains("4")==true){
//                d1=true;
//            }else {
//                d1=false;
//            }
//        }
//


//                    ",mlthinh".startsWith(",");
////                    2,3
////                    ketQua.replaceAll("0,", "");
////                    ketQua.endsWith("0");
////                    ketQua.replace(",0", "";)

        Log.e("kq1", ketQua);

        ketQua = ketQua.replaceAll("0,", "");
        if (ketQua.endsWith(",0") == true) {
            ketQua = ketQua.replace(",0", "");
        }

        Log.e("ketqua", ketQua);

//        Toast.makeText(context, ketQua, Toast.LENGTH_SHORT).show();

        if (ans.contains(ketQua) == true) {
            caudung++;
        } else {
//            causai++;
        }
        Log.e("cau", "cau dung" + caudung);
        Log.e("cau", "cau sai" + causai);

        if (ans.contains("1") == true) {
            Log.e("abc", "rada");
            radA.setTextColor(Color.rgb(0, 250, 154));
        }
        if (ans.contains("2") == true) {
            Log.e("abc", "rada");
            radB.setTextColor(Color.rgb(0, 250, 154));
        }
        if (ans.contains("3") == true) {
            Log.e("abc", "rada");
            radC.setTextColor(Color.rgb(0, 250, 154));
        }
        if (ans.contains("4") == true) {
            Log.e("abc", "rada");
            radD.setTextColor(Color.rgb(0, 250, 154));
        }
    }


    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void checkChangeRadioButton(int a, String a1) {
        arr_ques.get(mPageNumber).dap_an = a;
        arr_ques.get(mPageNumber).setTra_loi(a1);
    }

    private void replace() {
        ketQua = ketQua.replaceAll("0,", "");
        if (ketQua.endsWith(",0") == true) {
            ketQua = ketQua.replace(",0", "");
        }
    }
//add onpageer lisentner
}

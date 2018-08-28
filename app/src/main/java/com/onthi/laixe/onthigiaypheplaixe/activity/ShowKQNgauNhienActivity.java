package com.onthi.laixe.onthigiaypheplaixe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.Question;
import com.onthi.laixe.onthigiaypheplaixe.models.SharedPreferencesManager;

import java.util.ArrayList;

public class ShowKQNgauNhienActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_cau_dung, tv_cau_sai, tv_tong_diem, tv_danh_gia;
    private Button btn_Kq_ngau_nhien,Btn_thoat_ngau_nhien;
    private ArrayList<Question> list = new ArrayList<Question>();
    private int caudung=0,causai=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_kq_ngau_nhien);
        Intent intent= getIntent();
        list = (ArrayList<Question>) intent.getExtras().getSerializable("arr_question");
        ininView();
        checkCauHoi();
        tv_cau_dung.setText(String.valueOf(caudung));
        tv_cau_sai.setText(String.valueOf(list.size()-caudung));
        tv_tong_diem.setText(String.valueOf(caudung));

        if (list.size()>20){
            tv_danh_gia.setVisibility(View.GONE);
        }else {
            if (caudung>=0&&caudung<16){
                tv_danh_gia.setText("Trượt");
            }else if (caudung<=20&&caudung>=16){
                tv_danh_gia.setText("Đỗ");
            }
        }


        Log.e("????", caudung+"");
    }

    private void ininView() {
        tv_cau_dung = findViewById(R.id.tv_cau_dung_ngau_nhien);
        tv_cau_sai = findViewById(R.id.tv_cau_sai_ngau_nhien);
        tv_tong_diem = findViewById(R.id.tv_tong_diem_ngau_nhien);
        tv_danh_gia = findViewById(R.id.tv_danh_gia_ngau_nhien);
        btn_Kq_ngau_nhien = findViewById(R.id.btn_Kq_ngau_nhien);
        Btn_thoat_ngau_nhien = findViewById(R.id.btn_thoat_ngau_nhien);

        tv_cau_dung.setOnClickListener(this);
        tv_cau_sai.setOnClickListener(this);
        tv_tong_diem.setOnClickListener(this);
        tv_danh_gia.setOnClickListener(this);
        btn_Kq_ngau_nhien.setOnClickListener(this);
        Btn_thoat_ngau_nhien.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cau_dung_ngau_nhien:
                break;
            case R.id.tv_cau_sai_ngau_nhien:
                break;
            case R.id.tv_tong_diem_ngau_nhien:
                break;
            case R.id.tv_danh_gia_ngau_nhien:

                break;
            case R.id.btn_Kq_ngau_nhien:
                SharedPreferencesManager.setButtonEnd(this,true);
                finish();
                break;
            case R.id.btn_thoat_ngau_nhien:
                SharedPreferencesManager.setButtonEnd(this,false );
                finish();
                sendBroadcast(new Intent("finish_ngaunhien"));
                break;
        }
    }

    private void checkCauHoi(){
        for (int i=0;i<list.size();i++){
            if (list.get(i).getKetqua().equals(list.get(i).getTra_loi().toString())==true){
                caudung++;
            }
        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferencesManager.setButtonEnd(this,false);
        super.onBackPressed();
    }
}

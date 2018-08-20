package com.onthi.laixe.onthigiaypheplaixe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.onthi.laixe.onthigiaypheplaixe.adapters.DeThiAdapter;
import com.onthi.laixe.onthigiaypheplaixe.models.DeThi;

import java.util.ArrayList;


public class DeThiActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private DeThiAdapter deThiadapter;
    private GridView gvDeThi;
    private ArrayList<DeThi> arrayList = new ArrayList<>();
    private ImageView iv_Back;
    public static final String KEY_INTENT = "Key_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_thi);
//        getSupportActionBar().setTitle("Bộ Đề");

        initView();
        gvDeThi = findViewById(R.id.Gv_layout);
        arrayList.add(new DeThi("Đề Số 1"));
        arrayList.add(new DeThi("Đề Số 2"));
        arrayList.add(new DeThi("Đề Số 3"));
        arrayList.add(new DeThi("Đề Số 4"));
        arrayList.add(new DeThi("Đề Số 5"));
        arrayList.add(new DeThi("Đề Số 6"));
        arrayList.add(new DeThi("Đề Số 7"));
        arrayList.add(new DeThi("Đề Số 8"));
        arrayList.add(new DeThi("Đề Số 9"));

        deThiadapter = new DeThiAdapter(this, arrayList);
        gvDeThi.setAdapter(deThiadapter);
        gvDeThi.setOnItemClickListener(this);
    }

    private void initView() {
        iv_Back = findViewById(R.id.iv_back);
        iv_Back.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                Intent intent = new Intent(this, ScreenSlideActivity.class);
                intent.putExtra(KEY_INTENT,i);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 1:
                Intent intent1 = new Intent(this, ScreenSlideActivity.class);
                intent1.putExtra(KEY_INTENT,i);
                startActivity(intent1);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 2:
                Intent intent2 = new Intent(this, ScreenSlideActivity.class);
                intent2.putExtra(KEY_INTENT,i);
                sendBroadcast(new Intent("2"));
                startActivity(intent2);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 3:
                Intent intent3 = new Intent(this, ScreenSlideActivity.class);
                intent3.putExtra(KEY_INTENT,i);
                startActivity(intent3);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 4:
                Intent intent4 = new Intent(this, ScreenSlideActivity.class);
                intent4.putExtra(KEY_INTENT,i);
                startActivity(intent4);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 5:
                Intent intent5 = new Intent(this, ScreenSlideActivity.class);
                intent5.putExtra(KEY_INTENT,i);
                startActivity(intent5);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 6:
                Intent intent6 = new Intent(this, ScreenSlideActivity.class);
                intent6.putExtra(KEY_INTENT,i);
                startActivity(intent6);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 7:
                Intent intent7 = new Intent(this, ScreenSlideActivity.class);
                intent7.putExtra(KEY_INTENT,i);
                startActivity(intent7);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 8:
                Intent intent8 = new Intent(this, ScreenSlideActivity.class);
                intent8.putExtra(KEY_INTENT,i);
                startActivity(intent8);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;

        }

    }
}

package com.onthi.laixe.onthigiaypheplaixe.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.adapters.ChuDeAdapter;
import com.onthi.laixe.onthigiaypheplaixe.models.ChuDe;
import com.onthi.laixe.onthigiaypheplaixe.models.SharedPreferencesManager;

import java.util.ArrayList;

public class ChuDeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ChuDeAdapter chuDeAdapter;
    private GridView gvChuDe;
    private ArrayList<ChuDe> arrayList = new ArrayList<>();
    private ImageView iv_Back;
    private BroadcastReceiver receiver;
    private IntentFilter filter;
    public static final String KEY_INTENT_CHU_DE = "Key_intent_chu_de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_thi);
//        getSupportActionBar().setTitle("Bộ Đề");

        initView();
        gvChuDe = findViewById(R.id.Gv_layout);
        gvChuDe.setNumColumns(1);
        arrayList.add(new ChuDe("Lý Thuyết"));
        arrayList.add(new ChuDe("Biển Báo"));
        arrayList.add(new ChuDe("Sa Hình"));
        chuDeAdapter = new ChuDeAdapter(this, arrayList);
        gvChuDe.setAdapter(chuDeAdapter);
        gvChuDe.setOnItemClickListener(this);
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
        SharedPreferencesManager.setButtonEnd(this,false);
        switch (i){
            case 0:
                Intent intent = new Intent(this, ScreenSlideChuDeActivity.class);
                intent.putExtra(KEY_INTENT_CHU_DE,"LT");
                intent.putExtra("numpage",90);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 1:
                Intent intent1 = new Intent(this, ScreenSlideChuDeActivity.class);
                intent1.putExtra(KEY_INTENT_CHU_DE,"BB");
                startActivity(intent1);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case 2:
                Intent intent2 = new Intent(this, ScreenSlideChuDeActivity.class);
                intent2.putExtra(KEY_INTENT_CHU_DE,"SH");
                sendBroadcast(new Intent("2"));
                startActivity(intent2);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
        }

    }
}
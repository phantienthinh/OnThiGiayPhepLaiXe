package com.onthi.laixe.onthigiaypheplaixe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.DBHelper;
import com.onthi.laixe.onthigiaypheplaixe.models.SharedPreferencesManager;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_bo_de, rl_chu_de, rl_on_tap, rl_ngau_nhien, rl_bien_bao, rl_meo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper = new DBHelper(this);

        try {
            dbHelper.deleteDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initView();
    }

    private void initView() {
        rl_meo = findViewById(R.id.rl_meo);
        rl_bien_bao = findViewById(R.id.rl_bien_bao);
        rl_ngau_nhien = findViewById(R.id.rl_ngau_nhien);
        rl_on_tap = findViewById(R.id.rl_on_tap);
        rl_chu_de = findViewById(R.id.rv_chu_de);
        rl_bo_de = findViewById(R.id.rl_bo_de);
        rl_bo_de.setOnClickListener(this);
        rl_chu_de.setOnClickListener(this);
        rl_on_tap.setOnClickListener(this);
        rl_ngau_nhien.setOnClickListener(this);
        rl_bien_bao.setOnClickListener(this);
        rl_meo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        SharedPreferencesManager.setButtonEnd(this, false);
        switch (v.getId()) {
            case R.id.rl_bo_de:
                Intent intent = new Intent(this, DeThiActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case R.id.rv_chu_de:
                Intent intent1 = new Intent(this, ChuDeActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case R.id.rl_on_tap:
                Intent intent2 = new Intent(this, OnTapActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case R.id.rl_ngau_nhien:
                Intent intent3 = new Intent(this, NgauNhienActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case R.id.rl_bien_bao:
                Intent intent4 = new Intent(this, BienBaoActivity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
            case R.id.rl_meo:
                Intent intent5 = new Intent(this, MeoActivity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
                break;
        }
    }
}

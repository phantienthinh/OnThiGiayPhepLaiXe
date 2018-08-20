package com.onthi.laixe.onthigiaypheplaixe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.models.DBHelper;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_bo_de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper = new DBHelper(this);
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initView();
    }

    private void initView() {
        rl_bo_de = findViewById(R.id.rl_bo_de);
        rl_bo_de.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_bo_de:
                Intent intent = new Intent(this,DeThiActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_start,R.anim.anim_back);
                break;
        }
    }
}

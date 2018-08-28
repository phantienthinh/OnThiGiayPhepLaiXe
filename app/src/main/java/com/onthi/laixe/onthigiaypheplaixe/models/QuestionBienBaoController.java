package com.onthi.laixe.onthigiaypheplaixe.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class QuestionBienBaoController {
    private DBHelper dbHelper;

    public QuestionBienBaoController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<BienBao> getQuestion(String loai) {
        ArrayList<BienBao> lsData = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bienbao Where loai='" + loai + "'", null);
        cursor.moveToFirst();
        do {
            BienBao item;
            item = new BienBao(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)
                    ,cursor.getString(4));
            lsData.add(item);
            Log.e("ITem", cursor.getInt(0) +cursor.getString(1)+cursor.getString(2)+cursor.getString(3)
                   +cursor.getString(4));

        } while (cursor.moveToNext());
        return lsData;
    }
}

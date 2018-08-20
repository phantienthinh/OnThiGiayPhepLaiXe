package com.onthi.laixe.onthigiaypheplaixe.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SharedPreferencesManager {

    public static void setTimeSleep(Context context, String is) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString("KEY_TimeSleep", is).apply();
    }

    public static String getTimeSleep(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("KEY_TimeSleep", "00:00");
    }


}
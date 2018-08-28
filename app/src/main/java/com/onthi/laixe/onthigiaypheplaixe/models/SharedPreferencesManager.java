package com.onthi.laixe.onthigiaypheplaixe.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SharedPreferencesManager {

    public static void setButtonEnd(Context context, boolean is) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putBoolean("KEY_ButtonEnd", is).apply();
    }

    public static boolean getButtonEnd(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("KEY_ButtonEnd", false);
    }


}
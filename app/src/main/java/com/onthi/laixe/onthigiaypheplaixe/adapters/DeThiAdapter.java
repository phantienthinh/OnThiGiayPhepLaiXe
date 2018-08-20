package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.DeThi;

import java.util.ArrayList;

public class DeThiAdapter extends ArrayAdapter<DeThi> {
    public DeThiAdapter(@NonNull Context context, ArrayList<DeThi>deThi) {
        super(context,0,deThi);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_gridview,parent,false);
        }
        TextView tv_name = convertView.findViewById(R.id.tv_de_thi);
        ImageView iv_de_thi = convertView.findViewById(R.id.iv_de_thi);

        DeThi deThi = getItem(position);
        if (deThi!=null){
            tv_name.setText(deThi.getName());
            iv_de_thi.setImageResource(R.drawable.exam);
        }

        return convertView;
    }
}

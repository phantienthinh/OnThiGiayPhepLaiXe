package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.ChuDe;

import java.util.ArrayList;

public class ChuDeAdapter extends ArrayAdapter<ChuDe > {
    public ChuDeAdapter(@NonNull Context context, ArrayList<ChuDe> chuDes) {
        super(context, 0, chuDes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_gridview_chude, parent, false);
        }
        TextView tv_name = convertView.findViewById(R.id.tv_de_thi);
        ImageView iv_de_thi = convertView.findViewById(R.id.iv_de_thi);

        ChuDe chuDe = getItem(position);
        if (chuDe != null) {
            tv_name.setText(chuDe.getName());
            switch (position){
                case 0:
                    iv_de_thi.setImageResource(R.drawable.image);
                    break;
                case 1:
                    iv_de_thi.setImageResource(R.drawable.icon_bien_bao);
                    break;
                case 2:
                    iv_de_thi.setImageResource(R.drawable.icon_sa_hinh);
                    break;

            }
        }

        return convertView;
    }
}

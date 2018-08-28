package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.BienBao;

import java.util.ArrayList;

public class BienBaoAdapter extends BaseAdapter {

    ArrayList list;
    LayoutInflater inflater;

    public BienBaoAdapter(ArrayList list, Context context) {
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        BienBao data = (BienBao) getItem(position);
        BienBaoAdapter.ViewHoder hoder;
        Context context = viewGroup.getContext();
        if (view==null){
            hoder = new BienBaoAdapter.ViewHoder();
            view = inflater.inflate(R.layout.item_lisview_bien_bao,null);
            hoder.tv_title = (TextView)view.findViewById(R.id.tv_title);
            hoder.iv_bien_bao = (ImageView)view.findViewById(R.id.image_list);
            hoder.tv_note = (TextView)view.findViewById(R.id.tv_Description);
            view.setTag(hoder);
        }
        else {
            hoder = (BienBaoAdapter.ViewHoder)view.getTag();
        }
//        int i = position+1;


//        hoder.iv_bien_bao.setImageResource();
        hoder.tv_title.setText(data.getTitle());
        hoder.tv_note.setText(data.getText());

        return view;
    }
    private static class ViewHoder{
        ImageView iv_bien_bao;
        TextView tv_title,tv_note;
    }

}
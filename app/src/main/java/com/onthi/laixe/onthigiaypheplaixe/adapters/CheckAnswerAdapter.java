package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.Question;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {

    ArrayList list;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList list, Context context) {
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
        Question data = (Question)getItem(position);
        ViewHoder hoder;
        if (view==null){
            hoder = new ViewHoder();
            view = inflater.inflate(R.layout.item_gridview_dialog,null);
            hoder.tv_Answer = (TextView)view.findViewById(R.id.tv_answer);
            hoder.tv_number_Answer = (TextView)view.findViewById(R.id.tv_number_answer);
            view.setTag(hoder);
        }
        else {
            hoder = (ViewHoder)view.getTag();
        }
        int i = position+1;
        hoder.tv_number_Answer.setText("Câu"+i+":");
        hoder.tv_Answer.setText(data.getTra_loi());

        return view;
    }
    private static class ViewHoder{
        TextView tv_number_Answer,tv_Answer;
    }
}

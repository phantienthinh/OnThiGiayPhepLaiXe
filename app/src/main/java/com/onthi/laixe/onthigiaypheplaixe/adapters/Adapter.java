package com.onthi.laixe.onthigiaypheplaixe.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.models.BienBao;

import java.io.InputStream;
import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private int resource;
    private ArrayList<BienBao> arrBienBao;

    public Adapter(Context context, int resource, ArrayList<BienBao> arrBienBao) {
        this.context = context;
        this.resource = resource;
        this.arrBienBao = arrBienBao;
    }

    @Override
    public int getCount() {
        return arrBienBao.size();
    }

    @Override
    public Object getItem(int i) {
        return arrBienBao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_lisview_bien_bao,null);

        TextView tv_title =convertView.findViewById(R.id.tv_title);
        TextView tv_note = convertView.findViewById(R.id.tv_Description);
        ImageView iv_bien_bao = convertView.findViewById(R.id.image_list);

        tv_title.setText(arrBienBao.get(position).getTitle());
        tv_note.setText(arrBienBao.get(position).getText());
        String a = arrBienBao.get(position).getImage();
        Log.e("1111", a);
        a= a.replaceAll("png","webp");
        Log.e("1112", a );
        try {
            // get input stream
            InputStream ims = context.getAssets().open(a);
            // load image as Drawable
            Log.e("1114", "deo ok" );
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            Log.e("1113", "ok" );
            iv_bien_bao.setImageDrawable(d);
        }catch (Exception e){

        }


        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_up_fast);
        convertView.startAnimation(animation);

        return convertView;
    }

    public Context getContext() {
        this.context = context;
        return context;
    }
}

package com.onthi.laixe.onthigiaypheplaixe.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.adapters.Adapter;
import com.onthi.laixe.onthigiaypheplaixe.adapters.BienBaoAdapter;
import com.onthi.laixe.onthigiaypheplaixe.models.BienBao;
import com.onthi.laixe.onthigiaypheplaixe.models.QuestionBienBaoController;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaoHieuLenhFragment extends Fragment {

    Context context;
    QuestionBienBaoController bienBaoController;
    //    List<BienBao> listBienbaos;
    ArrayList<BienBao>bienBaoArrayList,list;
    BienBaoAdapter bienBaoAdapter;
    public BaoHieuLenhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bien_bao,container,false);
        ListView listView = (ListView)view.findViewById(R.id.list_view);
        bienBaoController= new QuestionBienBaoController(context);
        ArrayList<BienBao> arrayList = new ArrayList<>();

        arrayList = bienBaoController.getQuestion("BBHL");

        Adapter adapter = new Adapter(context,R.layout.item_lisview_bien_bao,arrayList);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }
}

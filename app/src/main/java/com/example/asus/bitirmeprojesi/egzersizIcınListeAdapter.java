package com.example.asus.bitirmeprojesi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class egzersizIcınListeAdapter extends BaseAdapter {
    private List list;
    Context context;
    LayoutInflater layoutInflater;
    public egzersizIcınListeAdapter(Egzersiz_Cesitleri context, List list){
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View satirView=layoutInflater.inflate(R.layout.egzersiz_cesitleri_yerlesim,null);
        ImageView ivKisiResmi = (ImageView) satirView.findViewById(R.id.simge);
        TextView tvAd = (TextView) satirView.findViewById(R.id.egzersiz_cesidi);

        EgzersizCesitleriYerlesim egzersiz= (EgzersizCesitleriYerlesim) list.get(position);

        ivKisiResmi.setImageResource(egzersiz.getResimID());
        tvAd.setText(egzersiz.getEgzersizAdi());

        return satirView;
    }

}

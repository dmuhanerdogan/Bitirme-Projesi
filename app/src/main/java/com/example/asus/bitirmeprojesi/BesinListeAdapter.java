package com.example.asus.bitirmeprojesi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BesinListeAdapter extends BaseAdapter {
    private List list;
    Context context;
    LayoutInflater layoutInflater;
    public BesinListeAdapter(Beslenme_Onerileri context, List list){
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
        View satirView=layoutInflater.inflate(R.layout.beslenme_onerileri_yerlesim,null);
        ImageView ivKisiResmi = (ImageView) satirView.findViewById(R.id.simge2);
        TextView tvAd = (TextView) satirView.findViewById(R.id.besin_cesidi);

        BeslenmeOnerileriYerlesim besin= (BeslenmeOnerileriYerlesim) list.get(position);

        ivKisiResmi.setImageResource(besin.getResimID2());
        tvAd.setText(besin.getBesinAdi());

        return satirView;
    }

}

package com.example.asus.bitirmeprojesi;

/**
 * Created by ASUS on 22.11.2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Egzersiz_Cesitleri extends AppCompatActivity {

    ListAdapter adapter;
    List egzersizler;
    ListView liste;
    MainActivity a=new MainActivity();
    public void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.egzersiz_main);



        liste=(ListView)findViewById(R.id.listview);


       /* final String[] egzersizIsimler={"Kol Egzersizi", "Bacak Egzersizi", "Karın Egzersizi"};
        final ArrayAdapter adapter=new ArrayAdapter(Egzersiz_Cesitleri.this,android.R.layout.simple_list_item_1,egzersizIsimler);

        liste.setAdapter(adapter);
*/
        egzersizler=new ArrayList<>();
        egzersizler.add(new EgzersizCesitleriYerlesim("Karın Egzersizleri",R.drawable.karinkasi));
        egzersizler.add(new EgzersizCesitleriYerlesim("Bacak Egzersizleri",R.drawable.bacakkasi));
        egzersizler.add(new EgzersizCesitleriYerlesim("Kol Egzersizleri",R.drawable.kolkasi));
        adapter=new egzersizIcınListeAdapter(this,egzersizler);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(adapter.getItemId(position)==0){
                    Intent gec=new Intent(Egzersiz_Cesitleri.this,egzersiz_hareketleri.class);
                    startActivity(gec);
                    Egzersiz_Cesitleri.this.finish();
                }
                else if(adapter.getItemId(position)==1)
                {
                    Intent gec=new Intent(Egzersiz_Cesitleri.this,Bacak_egzersiz.class);
                    startActivity(gec);
                    Egzersiz_Cesitleri.this.finish();
                }
                else if(adapter.getItemId(position)==2)
                {
                    Intent gec=new Intent(Egzersiz_Cesitleri.this,Kol_egzersiz.class);
                    startActivity(gec);
                    Egzersiz_Cesitleri.this.finish();
                }
            }
        });



    }
    @Override
    public void onBackPressed()
    {

        Intent main_sayfa = new Intent(Egzersiz_Cesitleri.this, MainActivity.class);
        Egzersiz_Cesitleri.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();



    }

}





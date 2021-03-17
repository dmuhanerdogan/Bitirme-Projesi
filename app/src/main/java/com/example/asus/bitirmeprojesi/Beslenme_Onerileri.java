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

public class Beslenme_Onerileri  extends AppCompatActivity{
    ListAdapter adapter2;
    List besinler;
    ListView liste2;
    MainActivity a=new MainActivity();
    public void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.beslenme_main);



        liste2=(ListView)findViewById(R.id.listview);


       /* final String[] egzersizIsimler={"Kol Egzersizi", "Bacak Egzersizi", "Karın Egzersizi"};
        final ArrayAdapter adapter=new ArrayAdapter(Egzersiz_Cesitleri.this,android.R.layout.simple_list_item_1,egzersizIsimler);

        liste.setAdapter(adapter);
*/
        besinler=new ArrayList<>();
        besinler.add(new BeslenmeOnerileriYerlesim("Et ve Et Ürünleri",R.drawable.et));
        besinler.add(new BeslenmeOnerileriYerlesim("Süt ve Süt Ürünleri",R.drawable.sut));
        besinler.add(new BeslenmeOnerileriYerlesim("Deniz Ürünleri",R.drawable.deniz));
        besinler.add(new BeslenmeOnerileriYerlesim("Sebzeler ve Meyveler",R.drawable.sebze));
        besinler.add(new BeslenmeOnerileriYerlesim("Unlu Gıdalar",R.drawable.ekmek));


        adapter2=new BesinListeAdapter(this,besinler);
        liste2.setAdapter(adapter2);
        liste2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(adapter2.getItemId(position)==0){
                    Intent gec=new Intent(Beslenme_Onerileri.this,Et_Urunleri.class);
                    startActivity(gec);
                    Beslenme_Onerileri.this.finish();
                }
                else if(adapter2.getItemId(position)==1)
                {
                    Intent gec=new Intent(Beslenme_Onerileri.this,Sut_Urunleri.class);
                    startActivity(gec);
                    Beslenme_Onerileri.this.finish();
                }
                else if(adapter2.getItemId(position)==2)
                {
                    Intent gec=new Intent(Beslenme_Onerileri.this,Deniz_Urunleri.class);
                    startActivity(gec);
                    Beslenme_Onerileri.this.finish();
                }
                else if(adapter2.getItemId(position)==3)
                {
                    Intent gec=new Intent(Beslenme_Onerileri.this,Sebze_Urunleri.class);
                    startActivity(gec);
                    Beslenme_Onerileri.this.finish();
                }
                else if(adapter2.getItemId(position)==4)
                {
                    Intent gec=new Intent(Beslenme_Onerileri.this,Unlu_Gidalar.class);
                    startActivity(gec);
                    Beslenme_Onerileri.this.finish();
                }



            }
        });



    }
    @Override
    public void onBackPressed()
    {

        Intent main_sayfa = new Intent(Beslenme_Onerileri.this, MainActivity.class);
        Beslenme_Onerileri.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();



    }

}

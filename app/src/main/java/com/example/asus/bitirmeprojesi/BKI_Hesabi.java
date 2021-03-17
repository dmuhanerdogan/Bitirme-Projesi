package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;
import java.lang.Object;
import java.text.DecimalFormat;
import android.widget.Toast;
import java.util.Formatter;

public class BKI_Hesabi extends AppCompatActivity {

    int geri_sayac=0;
    MainActivity main=new MainActivity();
    Button buton_sonuc,b_sonuc,b_sonuc2;
    EditText boy,kilo,text_sonuc;
    Double bki,boyText,kiloText;
    ImageView s_normal,s_yanlisimage,s_yesil_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bki_main);

        buton_sonuc=(Button)findViewById(R.id.buton_sonuc);
        kilo=(EditText)findViewById(R.id.kilo);
        boy=(EditText)findViewById(R.id.boy);
        b_sonuc=(Button)findViewById(R.id.b_sonuc);
        b_sonuc2=(Button)findViewById(R.id.b_sonuc2);
        s_normal=(ImageView)findViewById(R.id.s_normalimage);
        s_yanlisimage=(ImageView)findViewById((R.id.s_yanlisimage));
        //konusma_balonuimage=(ImageView)findViewById(R.id.konusma_balonuimage);
        s_yesil_image=(ImageView)findViewById((R.id.s_yesil_image));
        s_yanlisimage.setVisibility(View.INVISIBLE);
        s_yesil_image.setVisibility(View.INVISIBLE);
       // progressBar=(ProgressBar)findViewById(R.id.progressBar);

        buton_sonuc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DecimalFormat df= new DecimalFormat("#.#");//Double formatlama yapıyor.
                kiloText=Double.parseDouble((kilo.getText().toString()));
                boyText=Double.parseDouble(boy.getText().toString());
                if(boyText>0 && kiloText>0) {
                    if(boyText>=100) {
                        boyText = boyText / 100;//cm'i metreye çeviriyor.
                    }
                    bki = (kiloText / (boyText * boyText));
                    //Toast.makeText(BKI_Hesabi.this,"Hesaplama tamamlandı.", Toast.LENGTH_LONG).show();
                    b_sonuc2.setText("Beden Kitle İndeksiniz:" + df.format(bki));
                    if (bki <= 18.5) {
                        b_sonuc.setText("Kilonuz Zayıf");
                        s_yanlisimage.setVisibility(View.VISIBLE);
                        s_normal.setVisibility(View.INVISIBLE);
                        s_yesil_image.setVisibility(View.INVISIBLE);
                    } else if (18.5 < bki && bki <= 24.9) {
                        b_sonuc.setText("Kilonuz Normal");
                        s_yesil_image.setVisibility(View.VISIBLE);
                        s_normal.setVisibility(View.INVISIBLE);
                        s_yanlisimage.setVisibility(View.INVISIBLE);
                    } else if (25.0 <= bki && bki <= 29.9) {
                        b_sonuc.setText("Fazla Kilolu");
                        s_yanlisimage.setVisibility(View.VISIBLE);
                        s_normal.setVisibility(View.INVISIBLE);
                        s_yesil_image.setVisibility(View.INVISIBLE);
                    } else if (30.0 <= bki && bki <= 34.9) {
                        b_sonuc.setText("1.Derece Obez");
                        s_yanlisimage.setVisibility(View.VISIBLE);
                        s_normal.setVisibility(View.INVISIBLE);
                        s_yesil_image.setVisibility(View.INVISIBLE);
                    } else if (35.0 <= bki && bki <= 40.0) {
                        b_sonuc.setText("2.Derece Obez");
                        s_yanlisimage.setVisibility(View.VISIBLE);
                        s_normal.setVisibility(View.INVISIBLE);
                        s_yesil_image.setVisibility(View.INVISIBLE);
                    } else {
                        text_sonuc.setText("3.Derece Obez");
                        s_yanlisimage.setVisibility(View.VISIBLE);
                        s_normal.setVisibility(View.INVISIBLE);
                        s_yesil_image.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(BKI_Hesabi.this, MainActivity.class);
        BKI_Hesabi.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();

    }

}

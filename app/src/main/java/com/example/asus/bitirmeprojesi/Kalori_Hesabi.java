package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by ASUS on 22.11.2017.
 */
public class Kalori_Hesabi extends AppCompatActivity {

    Button kalorisonuc,textsonuc;
    EditText kilo2,boy2,yas,cinsiyet;
    Double kalori;
    Double textBoy;
    Double textKilo;
    Double textYas;
    RadioButton Erkek_radiobuton,Bayan_radiobuton;
    RadioGroup Cinsiyet_RadioGrup;


    protected void onCreate(Bundle savedIntanceState){


        super.onCreate(savedIntanceState);
        setContentView(R.layout.kalori_main);
        kalorisonuc=(Button)findViewById(R.id.kalorisonuc);
        kilo2=(EditText)findViewById(R.id.kilo2);
        boy2=(EditText)findViewById(R.id.boy2);
        yas=(EditText)findViewById(R.id.yas);
        Cinsiyet_RadioGrup=(RadioGroup)findViewById(R.id.Cinsiyet_radiogrup);
        Erkek_radiobuton=(RadioButton)findViewById(R.id.Erkek_radiobuton);
        Bayan_radiobuton=(RadioButton)findViewById(R.id.Bayan_radiobuton);
        //cinsiyet=(EditText)findViewById(R.id.cinsiyet);
        textsonuc=(Button)findViewById(R.id.textsonuc);

        kalorisonuc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                DecimalFormat df= new DecimalFormat("#.#");
                textKilo=Double.parseDouble(kilo2.getText().toString());
                textBoy=Double.parseDouble(boy2.getText().toString());
                textYas=Double.parseDouble(yas.getText().toString());

                int selectedId=Cinsiyet_RadioGrup.getCheckedRadioButtonId();
                switch (selectedId)
                {
                    case R.id.Bayan_radiobuton:{
                        kalori = 665+(9.6*textKilo)+(1.7*textBoy)-(4.7*textYas);
                        //Toast.makeText(Kalori_Hesabi.this,"Bayan için", Toast.LENGTH_LONG).show();
                        textsonuc.setText("Günlük Kalori İhtiyacınız:"+df.format(kalori));
                        break;
                    }
                    case R.id.Erkek_radiobuton:{
                        kalori=665+(13.75*textKilo)+(5*textBoy)-(6.8*textYas);
                        //Toast.makeText(Kalori_Hesabi.this, "Erkek için", Toast.LENGTH_LONG).show();
                        textsonuc.setText("Günlük Kalori İhtiyacınız:"+df.format(kalori));
                        break;
                    }
                }

            }
        });

    }
    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(Kalori_Hesabi.this, MainActivity.class);
        Kalori_Hesabi.this.startActivity(main_sayfa);//Main Sayfa açıldı.
        this.finish();


    }
}



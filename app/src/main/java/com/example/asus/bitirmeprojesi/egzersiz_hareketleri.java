package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class egzersiz_hareketleri extends AppCompatActivity {


    Button button;
    Button button7;
    Button button6;
    Button button8;

    Button button3;
    Button button5;
    Button button9;
    Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egzersiz_hareketleri);

        button=(Button)findViewById(R.id.button);
        button7=(Button)findViewById(R.id.button7);
        button6=(Button)findViewById(R.id.button6);
        button8=(Button)findViewById(R.id.button8);

        button3=(Button)findViewById(R.id.button3);
        button5=(Button)findViewById(R.id.button5);
        button9=(Button)findViewById(R.id.button9);
        button10=(Button)findViewById(R.id.button10);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                button3.setText("3X15");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                button5.setText("3X10");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                button9.setText("4X15");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                button10.setText("3X15");
            }
        });
    }
    @Override
    public void onBackPressed()
    {

        Intent egzersiz_cesitleri = new Intent(egzersiz_hareketleri.this, Egzersiz_Cesitleri.class);
        egzersiz_hareketleri.this.startActivity(egzersiz_cesitleri);//Egzersiz çeşitleri açıldı.
        this.finish();


    }
}

package com.example.asus.bitirmeprojesi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Hosgeldiniz extends AppCompatActivity {

    //Bu kısım boş bırakılmıştır.Sadece XML bağlantısı yapılmıştır.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosgeldiniz);
    }
    @Override
    public void onBackPressed()
    {

        Intent main_sayfa = new Intent(Hosgeldiniz.this, MainActivity.class);
        Hosgeldiniz.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();


    }
}
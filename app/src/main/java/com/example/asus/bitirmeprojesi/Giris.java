package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Giris extends AppCompatActivity
{

    EditText et_ad,et_sifre;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);

        et_ad= (EditText) findViewById(R.id.et_ad);
        et_sifre= (EditText) findViewById(R.id.et_sifre);

    }
    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(Giris.this, MainActivity.class);
        Giris.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }


    public void butonaDokunuldu(View v) {

        //Kullanıcı adı ve parola alınıyor.
        String kullaniciadi = et_ad.getText().toString();
        String sifresi = et_sifre.getText().toString();

        //Buton olayları tanımlanıyor.
        switch (v.getId()) {
            case R.id.btn_gir:

                if (sifresi.isEmpty() || kullaniciadi.isEmpty()) {
                    Toast.makeText(Giris.this, "Alanlar boş geçilemez!!!", Toast.LENGTH_SHORT).show();
                    break;
                }

                Veritabani db = new Veritabani(this);
//Sadece kullanıcı adını alıyor ve bu kullanıcının şifresini kontrol ediyor.Sonuca göre mesaj verdiriyor.

                String kontrol = db.KaydiKontrolEt(kullaniciadi);


                if (sifresi.equals(kontrol)) {
                    Toast.makeText(Giris.this, "Giriş yapıldı...", Toast.LENGTH_SHORT).show();

                    //Şifre doğruysa "Hoşgeldiniz" Intentine geçiliyor.
                    Intent main_sayfa = new Intent(getApplicationContext(), MainActivity.class);
                    Giris.this.startActivity(main_sayfa);//Main sayfa açıldı.
                    this.finish();//Bu sınıfı kapat.

                }
                else {
                    Toast.makeText(Giris.this, "Hatalı kullanıcı adı veya şifre!!!", Toast.LENGTH_SHORT).show();

                }
                break;



            case R.id.btn_kayit:

                //Kayıt işlemi için kayıt ol Intentine geçiş yapılıyor.
                Intent intent = new Intent(getApplicationContext(), KayitOl.class);
                startActivity(intent);
                break;

            case R.id.btn_temizle:

                //Temizleme butonu için tanımlama yapılıyor.
                et_ad.getText().clear();
                et_sifre.getText().clear();

                break;

        }
    }}
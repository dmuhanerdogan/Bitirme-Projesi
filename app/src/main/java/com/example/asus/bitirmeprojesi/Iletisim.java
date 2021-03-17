package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Iletisim extends AppCompatActivity {
    Button telefon,mesaj,email,websitesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iletisim_main);

        telefon = (Button)findViewById(R.id.button1);//Butonları uygulamaya tanıtıyoruz
        mesaj = (Button)findViewById(R.id.button2);//Butonları uygulamaya tanıtıyoruz
        //Butonları uygulamaya tanıtıyoruz
        email    = (Button)findViewById(R.id.button4);//Butonları uygulamaya tanıtıyoruz


        telefon.setOnClickListener(new View.OnClickListener() {//Telefon aç butonu tıklanınca

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1234567"));
                startActivity(intent);
            }
        });

        mesaj.setOnClickListener(new View.OnClickListener() {//mesaj at butonu tıklanınca

            @Override
            public void onClick(View v) {

                String telNo = "05055444444";//mesaj gönderilecek numara
                String mesaj = "Bu mesaj FİTFORM tarafından gönderilmiştir"; //mesaj

                //Bu kısım mesaj application açmak için.Yani sms uygulaması açılır. Numara kısmı ve mesaj kısmı otomatik doldurulur.

                Intent mesajGonder = new Intent(Intent.ACTION_VIEW);
                mesajGonder.setData(Uri.parse("sms:"+ telNo));
                mesajGonder.putExtra("sms_body", mesaj);
                startActivity(mesajGonder);


            }
        });



        email.setOnClickListener(new View.OnClickListener() { //Web Sitesi aç butonu

            @Override
            public void onClick(View v) {//Web sitesini tarayıcıda açar
                // TODO Auto-generated method stub
                String url = "http://mail.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(Iletisim.this, MainActivity.class);
        Iletisim.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }
}

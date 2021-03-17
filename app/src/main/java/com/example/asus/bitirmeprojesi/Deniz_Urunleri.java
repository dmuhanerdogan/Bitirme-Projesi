package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Deniz_Urunleri extends AppCompatActivity {
    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] deniz={"DENİZ ÜRÜNLERİ","LEVREK","MEZGİT","MİDYE","KARİDES","LÜFER","ISTAKOZ"};
    private String[] gr2={"100 gram","150 gram"};
    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner spinnerDeniz;
    private Spinner spinnerGr2;
    private ArrayAdapter<String> dataAdapterForDeniz;
    private ArrayAdapter<String> dataAdapterForGr2;
    Button sonuc3;


    @Override // Bu metod uygulama açıldığında çalıştırılan metod.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deniz_urunleri);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerDeniz = (Spinner) findViewById(R.id.spinner_deniz);
        spinnerGr2 = (Spinner) findViewById(R.id.spinner_gr2);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForDeniz = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, deniz);
        dataAdapterForGr2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,gr2);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForDeniz.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForGr2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerDeniz.setAdapter(dataAdapterForDeniz);
        spinnerGr2.setAdapter(dataAdapterForGr2);

        sonuc3=(Button)findViewById(R.id.sonuc3);

        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerDeniz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                dataAdapterForGr2 = new ArrayAdapter<String>(Deniz_Urunleri.this, android.R.layout.simple_spinner_item,gr2);

                dataAdapterForGr2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGr2.setAdapter(dataAdapterForGr2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerGr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                if (spinnerDeniz.getSelectedItem() == "LEVREK") {
                    if (spinnerGr2.getSelectedItem() == "100 gram") {
                        sonuc3.setText("94 kkal");
                    } else {
                        sonuc3.setText("141 kkal");
                    }
                } else if (spinnerDeniz.getSelectedItem() == "MEZGİT") {
                    if (spinnerGr2.getSelectedItem() == "100 gram") {
                        sonuc3.setText("134 kkal");
                    } else {
                        sonuc3.setText("201 kkal");
                    }
                } else if (spinnerDeniz.getSelectedItem() == "MİDYE") {
                    if (spinnerGr2.getSelectedItem() == "100 gram") {
                        sonuc3.setText("72 kkal");
                    } else {
                        sonuc3.setText("108 kkal");
                    }
                }
                else if (spinnerDeniz.getSelectedItem() == "KARİDES") {
                    if (spinnerGr2.getSelectedItem() == "100 gram") {
                        sonuc3.setText("86 kkal");
                    } else {
                        sonuc3.setText("129 kkal");
                    }
                }

                else if (spinnerDeniz.getSelectedItem() == "LÜFER") {
                    if (spinnerGr2.getSelectedItem() == "100 gram") {
                        sonuc3.setText("118 kkal");
                    } else {
                        sonuc3.setText("177 kkal");
                    }
                }

                else//ISTAKOZ
                {
                    if (spinnerGr2.getSelectedItem() == "100 gram") {
                        sonuc3.setText("90 kkal");
                    } else {
                        sonuc3.setText("135 kkal");
                    }
                }
            }



            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(Deniz_Urunleri.this, Beslenme_Onerileri.class);
        Deniz_Urunleri.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }





}






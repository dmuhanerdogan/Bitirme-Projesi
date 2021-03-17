package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Et_Urunleri extends AppCompatActivity {
    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] et={"ET ÜRÜNLERİ","BİFTEK","BONFİLE","TAVUK","HİNDİ","YAĞSIZ PİRZOLA"};
    private String[] gram={"50 gram","100 gram"};
    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner spinnerEt;
    private Spinner spinnerGram;
    private ArrayAdapter<String> dataAdapterForEt;
    private ArrayAdapter<String> dataAdapterForGram;
    Button sonuc;


    @Override // Bu metod uygulama açıldığında çalıştırılan metod.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.et_urunleri);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerEt = (Spinner) findViewById(R.id.spinner_et);
        spinnerGram = (Spinner) findViewById(R.id.spinner_gr);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForEt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, et);
        dataAdapterForGram = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,gram);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForEt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForGram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerEt.setAdapter(dataAdapterForEt);
        spinnerGram.setAdapter(dataAdapterForGram);

        sonuc=(Button)findViewById(R.id.sonuc);

        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerEt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                dataAdapterForGram = new ArrayAdapter<String>(Et_Urunleri.this, android.R.layout.simple_spinner_item,gram);

                dataAdapterForGram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGram.setAdapter(dataAdapterForGram);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerGram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                    if (spinnerEt.getSelectedItem() == "BİFTEK") {
                        if (spinnerGram.getSelectedItem() == "50 gram") {
                            sonuc.setText("103 kkal");
                        } else {
                            sonuc.setText("206 kkal");
                    }
                    } else if (spinnerEt.getSelectedItem() == "BONFİLE") {
                        if (spinnerGram.getSelectedItem() == "50 gram") {
                            sonuc.setText("100 kkal");
                        } else {
                            sonuc.setText("200 kkal");
                        }
                    } else if (spinnerEt.getSelectedItem() == "TAVUK") {
                        if (spinnerGram.getSelectedItem() == "50 gram") {
                            sonuc.setText("83 kkal");
                        } else {
                            sonuc.setText("166 kkal");
                        }
                    } else if (spinnerEt.getSelectedItem() == "HİNDİ") {
                        if (spinnerGram.getSelectedItem() == "50 gram") {
                            sonuc.setText("73 kkal");
                        } else {
                            sonuc.setText("147 kkal");
                        }
                    } else//PİRZOLA
                    {
                        if (spinnerGram.getSelectedItem() == "50 gram") {
                            sonuc.setText("102 kkal");
                        } else {
                            sonuc.setText("204 kkal");
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
        Intent main_sayfa = new Intent(Et_Urunleri.this, Beslenme_Onerileri.class);
        Et_Urunleri.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }





    }






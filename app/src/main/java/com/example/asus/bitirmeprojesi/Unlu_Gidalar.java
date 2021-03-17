package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Unlu_Gidalar extends AppCompatActivity {
    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] un={"UNLU GIDALAR","BEYAZ EKMEK","ÇAVDAR EKMEĞİ","TAM BUĞDAY EKMEĞİ","MAKARNA","ERİŞTE","YUFKA"};
    private String[] dilim={"1 Dilim","2 Dilim","1 Porsiyon","2 Porsiyon"};
    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner spinnerUn;
    private Spinner spinnerDilim;
    private ArrayAdapter<String> dataAdapterForUn;
    private ArrayAdapter<String> dataAdapterForDilim;

    Button sonuc5;

    @Override // Bu metod uygulama açıldığında çalıştırılan metod.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlu_gida);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerUn = (Spinner) findViewById(R.id.spinner_un);
        spinnerDilim = (Spinner) findViewById(R.id.spinner_dilim);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForUn = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, un);
        dataAdapterForDilim = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,dilim);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForUn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForDilim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerUn.setAdapter(dataAdapterForUn);
        spinnerDilim.setAdapter(dataAdapterForDilim);
        sonuc5=(Button)findViewById(R.id.sonuc5);
        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerUn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
                dataAdapterForDilim = new ArrayAdapter<String>(Unlu_Gidalar.this, android.R.layout.simple_spinner_item,dilim);

                dataAdapterForDilim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDilim.setAdapter(dataAdapterForDilim);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerDilim.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if (spinnerUn.getSelectedItem() == "BEYAZ EKMEK") {
                    if (spinnerDilim.getSelectedItem() == "1 Dilim") {
                        sonuc5.setText("77 kkal");
                    } else if(spinnerDilim.getSelectedItem() == "2 Dilim") {
                        sonuc5.setText("154 kkal");
                    }
                    else{
                        sonuc5.setText("");
                        Toast.makeText(getBaseContext(), "DİLİM OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                } else if (spinnerUn.getSelectedItem() == "ÇAVDAR EKMEĞİ") {
                    if (spinnerDilim.getSelectedItem() == "1 Dilim") {
                        sonuc5.setText("55 kkal");
                    } else if(spinnerDilim.getSelectedItem() == "2 Dilim") {
                        sonuc5.setText("110 kkal");
                    }
                    else{
                        sonuc5.setText("");
                        Toast.makeText(getBaseContext(), "DİLİM OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                } else if (spinnerUn.getSelectedItem() == "TAM BUĞDAY EKMEĞİ") {
                    if (spinnerDilim.getSelectedItem() == "1 Dilim") {
                        sonuc5.setText("64 kkal");
                    } else if(spinnerDilim.getSelectedItem() == "2 Dilim") {
                        sonuc5.setText("128 kkal");
                    }
                    else{
                        sonuc5.setText("");
                        Toast.makeText(getBaseContext(), "DİLİM OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                } else if (spinnerUn.getSelectedItem() == "MAKARNA") {
                    if (spinnerDilim.getSelectedItem() == "1 Porsiyon") {
                        sonuc5.setText("183 kkal");
                    } else if(spinnerDilim.getSelectedItem() == "2 Porsiyon") {
                        sonuc5.setText("366 kkal");
                    }
                    else{
                        sonuc5.setText("");
                        Toast.makeText(getBaseContext(), "PORSİYON SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }
                else if (spinnerUn.getSelectedItem() == "ERİŞTE") {
                    if (spinnerDilim.getSelectedItem() == "1 Porsiyon") {
                        sonuc5.setText("122 kkal");
                    } else if(spinnerDilim.getSelectedItem() == "2 Porsiyon"){
                        sonuc5.setText("244 kkal");
                    }
                    else{
                        sonuc5.setText("");
                        Toast.makeText(getBaseContext(), "PORSİYON SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }

                else//YUFKA
                {
                    if (spinnerDilim.getSelectedItem() == "1 Porsiyon") {
                        sonuc5.setText("165 kkal");
                    } else  if (spinnerDilim.getSelectedItem() == "2 Porsiyon") {
                        sonuc5.setText("330 kkal");
                    }
                    else{
                        sonuc5.setText("");
                        Toast.makeText(getBaseContext(), "PORSİYON SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(Unlu_Gidalar.this, Beslenme_Onerileri.class);
        Unlu_Gidalar.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }





}






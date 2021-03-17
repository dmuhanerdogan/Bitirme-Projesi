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

public class Sut_Urunleri extends AppCompatActivity {
    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] sut={"SÜT ÜRÜNLERİ","YAĞSIZ SÜT","YARIM YAĞLI SÜT","TAM YAĞLI SÜT","YAĞSIZ YOĞURT","TAM YAĞLI YOĞURT","BEYAZ PEYNİR","LOR PEYNİRİ"};
    private String[] ml={"1 Bardak","2 Bardak","30 gram","50 gram"};
    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner spinnerSut;
    private Spinner spinnerMl;
    private ArrayAdapter<String> dataAdapterForSut;
    private ArrayAdapter<String> dataAdapterForMl;
    Button sonuc2;


    @Override // Bu metod uygulama açıldığında çalıştırılan metod.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sut_urunleri);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerSut = (Spinner) findViewById(R.id.spinner_sut);
        spinnerMl = (Spinner) findViewById(R.id.spinner_ml);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForSut = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sut);
        dataAdapterForMl = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ml);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForSut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForMl.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerSut.setAdapter(dataAdapterForSut);
        spinnerMl.setAdapter(dataAdapterForMl);
        sonuc2=(Button)findViewById(R.id.sonuc2);

        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerSut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
                dataAdapterForMl = new ArrayAdapter<String>(Sut_Urunleri.this, android.R.layout.simple_spinner_item,ml);

                dataAdapterForMl.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerMl.setAdapter(dataAdapterForMl);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerMl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (spinnerSut.getSelectedItem() == "YAĞSIZ SÜT") {
                    if (spinnerMl.getSelectedItem() == "1 Bardak") {
                        sonuc2.setText("70 kkal");
                    } else if(spinnerMl.getSelectedItem() == "2 Bardak") {
                        sonuc2.setText("140 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "BARDAK OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                } else if (spinnerSut.getSelectedItem() == "YARIM YAĞLI SÜT") {
                    if (spinnerMl.getSelectedItem() == "1 Bardak") {
                        sonuc2.setText("99 kkal");
                    } else if(spinnerMl.getSelectedItem() == "2 Bardak") {
                        sonuc2.setText("198 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "BARDAK OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                } else if (spinnerSut.getSelectedItem() == "TAM YAĞLI SÜT") {
                    if (spinnerMl.getSelectedItem() == "1 Bardak") {
                        sonuc2.setText("123 kkal");
                    } else if(spinnerMl.getSelectedItem() == "2 Bardak") {
                        sonuc2.setText("246 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "BARDAK OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                } else if (spinnerSut.getSelectedItem() == "YAĞLSIZ YOĞURT") {
                    if (spinnerMl.getSelectedItem() == "1 Bardak") {
                        sonuc2.setText("117 kkal");
                    } else if(spinnerMl.getSelectedItem() == "2 Bardak") {
                        sonuc2.setText("234 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "BARDAK OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }
                else if (spinnerSut.getSelectedItem() == "TAM YAĞLI YOĞURT") {
                    if (spinnerMl.getSelectedItem() == "1 Bardak") {
                        sonuc2.setText("130 kkal");
                    } else if(spinnerMl.getSelectedItem() == "2 Bardak"){
                        sonuc2.setText("260 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "BARDAK OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }
                else if (spinnerSut.getSelectedItem() == "BEYAZ PEYNİR") {
                    if (spinnerMl.getSelectedItem() == "30 gram") {
                        sonuc2.setText("71 kkal");
                    } else if (spinnerMl.getSelectedItem() == "50 gram") {
                        sonuc2.setText("118 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "GRAM OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }
                else//LOR PEYNİRİ
                {
                    if (spinnerMl.getSelectedItem() == "30 gram") {
                        sonuc2.setText("26 kkal");
                    } else  if (spinnerMl.getSelectedItem() == "50 gram") {
                        sonuc2.setText("43 kkal");
                    }
                    else{
                        sonuc2.setText("");
                        Toast.makeText(getBaseContext(), "GRAM OLARAK SEÇİN :)", Toast.LENGTH_SHORT).show();}
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(Sut_Urunleri.this, Beslenme_Onerileri.class);
        Sut_Urunleri.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }





}






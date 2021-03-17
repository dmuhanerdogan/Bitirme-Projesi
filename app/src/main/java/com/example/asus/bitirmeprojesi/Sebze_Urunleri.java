package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Sebze_Urunleri extends AppCompatActivity {
    //Spinner içerisine koyacağımız verileri tanımlıyoruz.
    private String[] sebze={"SEBZE VE MEYVELER","BROKOLİ","KABAK","LAHANA","HAVUÇ","PATLICAN","DOMATES","FASULYE","ELMA","ÇİLEK","ARMUT","KİRAZ","ERİK","KARPUZ","KAYISI"};
    private String[] gr3={"100 gram","150 gram"};
    //Spinner'ları ve Adapter'lerini tanımlıyoruz.
    private Spinner spinnerSebze;
    private Spinner spinnerGr3;
    private ArrayAdapter<String> dataAdapterForSebze;
    private ArrayAdapter<String> dataAdapterForGr3;
    Button sonuc4;


    @Override // Bu metod uygulama açıldığında çalıştırılan metod.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sebze_meyve);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerSebze = (Spinner) findViewById(R.id.spinner_sebze);
        spinnerGr3 = (Spinner) findViewById(R.id.spinner_gr3);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForSebze = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sebze);
        dataAdapterForGr3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,gr3);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForSebze.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForGr3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerSebze.setAdapter(dataAdapterForSebze);
        spinnerGr3.setAdapter(dataAdapterForGr3);
        sonuc4=(Button)findViewById(R.id.sonuc4);
        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerSebze.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
                dataAdapterForGr3 = new ArrayAdapter<String>(Sebze_Urunleri.this, android.R.layout.simple_spinner_item,gr3);

                dataAdapterForGr3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGr3.setAdapter(dataAdapterForGr3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerGr3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (spinnerSebze.getSelectedItem() == "BROKOLİ") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("28 kkal");
                    } else {
                        sonuc4.setText("42 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "KABAK") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("18 kkal");
                    } else {
                        sonuc4.setText("27 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "LAHANA") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("20 kkal");
                    } else {
                        sonuc4.setText("30 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "HAVUÇ") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("48 kkal");
                    } else {
                        sonuc4.setText("72 kkal");
                    }
                }
                else if (spinnerSebze.getSelectedItem() == "PATLICAN") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("26 kkal");
                    } else {
                        sonuc4.setText("39 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "DOMATES") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("16 kkal");
                    } else {
                        sonuc4.setText("32 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "FASULYE") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("26 kkal");
                    } else {
                        sonuc4.setText("39 kkal");
                    }
                }
                else if (spinnerSebze.getSelectedItem() == "ELMA") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("62 kkal");
                    } else {
                        sonuc4.setText("93 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "ÇİLEK") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("37 kkal");
                    } else {
                        sonuc4.setText("56 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "ARMUT") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("59 kkal");
                    } else {
                        sonuc4.setText("89 kkal");
                    }
                }
                else if (spinnerSebze.getSelectedItem() == "KİRAZ") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("72 kkal");
                    } else {
                        sonuc4.setText("108 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "ERİK") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("55 kkal");
                    } else {
                        sonuc4.setText("82 kkal");
                    }
                } else if (spinnerSebze.getSelectedItem() == "KARPUZ") {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("32 kkal");
                    } else {
                        sonuc4.setText("48 kkal");
                    }
                }
                else//KAYISI
                {
                    if (spinnerGr3.getSelectedItem() == "100 gram") {
                        sonuc4.setText("48 kkal");
                    } else {
                        sonuc4.setText("72 kkal");
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
        Intent main_sayfa = new Intent(Sebze_Urunleri.this, Beslenme_Onerileri.class);
        Sebze_Urunleri.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıfı kapat.


    }





}






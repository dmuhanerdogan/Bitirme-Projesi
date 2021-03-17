package com.example.asus.bitirmeprojesi;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AdimSayar extends Activity implements SensorEventListener, StepListener {
    Switch switch_hedef;
    EditText hedef_edittext;
    private TextView textView,txtYazi;
    private SimpleStepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Adım Sayısı: ";
    private int numSteps;
    private static final int NOTIF_ID = 1;
    private int bildirim_sayac=0;
    private boolean switch_=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adim_main);
        textView=(TextView) findViewById(R.id.txt);
        hedef_edittext=(EditText)findViewById(R.id.Hedef_edittext);
        switch_hedef=(Switch)findViewById(R.id.Switch_hedef);
        switch_hedef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    Toast.makeText(getApplicationContext(), "Hedef Aktif Edildi.", Toast.LENGTH_LONG).show();
                    switch_=true;
                } else {
                    Toast.makeText(getApplicationContext(), "Hedef Pasif Edildi.", Toast.LENGTH_LONG).show();
                }
            }
        });
        hedef_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /*textView = new TextView(this);
        textView.setTextSize(30);
        setContentView(textView);*/

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new SimpleStepDetector();
        simpleStepDetector.registerListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        numSteps = 0;
        textView.setText(TEXT_NUM_STEPS + numSteps);
        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }
    public void Bildirim_Goster() {

        /* Bildirime tıkladığımızda Adımsayar.java dosyasına gidebilmek için
           bir intent oluşturuyoruz.*/
        Intent resultIntent = new Intent(this, AdimSayar.class);

        /* Bildirime tıklayınca iş yapabilmek için PendingIntent sınıfından bir nesne
           üretiyoruz. */
        PendingIntent pendingIntentResult = PendingIntent.getActivity(
                this, NOTIF_ID, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        /* Aşağıda setLargeIcon özelliği bizden bir Bitmap istediği için
           bu şekilde iconumuzu bitmape çeviriyoruz. */
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.stars);

        /* Bildirim oluşturabilmek için NotificationCompat.Builder ile bir nesne
           üretiyoruz. Üretilen mBuilder nesnesi ile bildirimimizin ayarlarını
           yapıyoruz. */
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Adım Sayar");
        mBuilder.setContentText("Tebrikler " + hedef_edittext.getText().toString() +" adıma ulaştınız");
        mBuilder.setSmallIcon(R.drawable.fruit);
        mBuilder.setLargeIcon(largeIcon);
        mBuilder.setAutoCancel(true);
        mBuilder.addAction(R.drawable.star, "Adım Sayar Detaylı GÖR", pendingIntentResult);
        mBuilder.setWhen(System.currentTimeMillis());
        mBuilder.setContentIntent(pendingIntentResult);
        mBuilder.setSubText("Adım Sayar");
        /*mBuilder.setStyle(new NotificationCompat.BigTextStyle()
                .bigText("Adım Sayar")
                .setBigContentTitle("Tebrikler 10.000 adıma ulaştınız :)"));*/

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setSound(uri);

        long[] v = {500, 1000};
        mBuilder.setVibrate(v);

        // NotificationManager nesnesi oluşturuyoruz.
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        // NotificationManager ile bildirimi inşa ediyoruz.
        notificationManager.notify(NOTIF_ID, mBuilder.build());

        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        if(numSteps>=Integer.parseInt(hedef_edittext.getText().toString())&& switch_==true)
        {
            Bildirim_Goster();
            //bildirim_sayac++;//Birden fazla bildirim gelmemesi için sayac artırıldı.
        }
        textView.setText(TEXT_NUM_STEPS + numSteps);

    }
    @Override
    public void onBackPressed()
    {
        Intent main_sayfa = new Intent(AdimSayar.this, MainActivity.class);
        AdimSayar.this.startActivity(main_sayfa);//Main sayfa açıldı.
        this.finish();//Bu sınıf kapat.


    }

}

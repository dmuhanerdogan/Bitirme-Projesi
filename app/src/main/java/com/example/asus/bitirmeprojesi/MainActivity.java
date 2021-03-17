package com.example.asus.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button bki_button;
    Button kalori_button;
    Button adimsayar_button;
    Button egzersiz_button;
    Button beslenme_button;
    //Context context=this;

    Button giris_button1;
    Button iletisim_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bki_button= (Button) findViewById(R.id.bki_hesabi_id);
        kalori_button= (Button) findViewById(R.id.kalori_id);
        adimsayar_button= (Button) findViewById(R.id.adimsayar_id);
        egzersiz_button= (Button) findViewById(R.id.egzersiz_id);
        beslenme_button= (Button) findViewById(R.id.beslenme_id);

        giris_button1= (Button) findViewById(R.id.giris_id);
        iletisim_button= (Button) findViewById(R.id.iletisim_id);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {

        this.finish();
        Toast.makeText(getApplicationContext(), " Uygulamadan çıkıldı.", Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       int id = item.getItemId();

        /*if(item.getItemId()==android.R.id.home)
        {
            Intent intent =new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }
        */
        //noinspection SimplifiableIfStatement
        if(id==R.id.home)
        {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.bki_hesabi_id) {
            Intent bki_sayfa = new Intent(MainActivity.this, BKI_Hesabi.class);
            MainActivity.this.startActivity(bki_sayfa);
            MainActivity.this.finish();

        } else if (id == R.id.kalori_id) {
            Intent kalori_sayfa = new Intent(MainActivity.this, Kalori_Hesabi.class);
            MainActivity.this.startActivity(kalori_sayfa);
            MainActivity.this.finish();

        }  else if (id == R.id.egzersiz_id) {
            Intent egzersiz_sayfa = new Intent(MainActivity.this, Egzersiz_Cesitleri.class);
            MainActivity.this.startActivity(egzersiz_sayfa);
            MainActivity.this.finish();
        } else if (id == R.id.beslenme_id) {
            Intent beslenme_sayfa = new Intent(MainActivity.this, Beslenme_Onerileri.class);
            MainActivity.this.startActivity(beslenme_sayfa);
            MainActivity.this.finish();
        } else if (id == R.id.adimsayar_id){
            Intent diyet_sayfa = new Intent(MainActivity.this, AdimSayar.class);
            MainActivity.this.startActivity(diyet_sayfa);
            MainActivity.this.finish();
        } else if(id == R.id.giris_id){
            Intent giris_sayfa2 = new Intent(MainActivity.this, Giris.class);
            MainActivity.this.startActivity(giris_sayfa2);
            MainActivity.this.finish();
        }
        else {
            Intent iletisim = new Intent(MainActivity.this, Iletisim.class);
            MainActivity.this.startActivity(iletisim);
            MainActivity.this.finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

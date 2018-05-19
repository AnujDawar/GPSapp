package com.example.anujdawar.gpsapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.net.*;

public class MainActivity extends AppCompatActivity
{
    private TextView textView;
    private HttpURLConnection httpURLConnection;
    private URL url;
    private String myLatitude, myLongitude;
    String responseMessage = "";
    int responseCode = 0;

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this, String.valueOf(responseCode), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLatitude = "123";
        myLongitude = "456";

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
//                    url = new URL("http://www.logitekprojects.com/sendTracking.php?lat="+myLatitude+
//                            "&long="+myLongitude+"&ID="+1);

                    url = new URL("http://ankitsehgalaries-001-site1.btempurl.com/ts/newDevdata?iString=1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(true);
                    responseCode = httpURLConnection.getResponseCode();
                }catch (Exception e) {}
            }
        });
        thread.start();
    }
}
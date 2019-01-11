package com.tngusmiso.mapsample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int loactionpermissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);//위치권한
        if(loactionpermissionCheck == PackageManager.PERMISSION_DENIED){  // 권한거부 되있다면
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1); //권한허용창
        }

        Button btBasic = (Button) findViewById(R.id.btBasic);
        Button btZoomPos = (Button) findViewById(R.id.btZoomPos);
        Button btGeocoding = (Button) findViewById(R.id.btGeocoding);
        Button btMarker = (Button) findViewById(R.id.btMarker);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                switch (v.getId()) {
                    case R.id.btBasic:
                        intent = new Intent(MainActivity.this, BasicMap.class);
                        break;
                    case R.id.btZoomPos:
                        intent = new Intent(MainActivity.this, ZoomMap.class);
                        break;
                    case R.id.btGeocoding:
                        intent = new Intent(MainActivity.this, GeocodingMap.class);
                        break;
                    case R.id.btMarker:
                        intent = new Intent(MainActivity.this, MarkerMap.class);
                        break;
                }
                startActivity(intent);
            }
        };

        btBasic.setOnClickListener(listener);
        btZoomPos.setOnClickListener(listener);
        btGeocoding.setOnClickListener(listener);
        btMarker.setOnClickListener(listener);
    }
}

package com.tngusmiso.mapsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btBasic = (Button) findViewById(R.id.btBasic);
        Button btZoomPos = (Button) findViewById(R.id.btZoomPos);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btBasic:
                        Intent intent = new Intent(MainActivity.this, BasicMap.class);
                        startActivity(intent);
                        break;
                    case R.id.btZoomPos:
                        Intent intent2 = new Intent(MainActivity.this, ZoomMap.class);
                        startActivity(intent2);
                        break;
                }
            }
        };

        btBasic.setOnClickListener(listener);
        btZoomPos.setOnClickListener(listener);
    }
}

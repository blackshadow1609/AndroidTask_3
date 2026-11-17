package com.campany.servicecounter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);

        btnStartService.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(this, CounterService.class);
            startService(serviceIntent);
        });

        btnStopService.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(this, CounterService.class);
            stopService(serviceIntent);
        });
    }
}
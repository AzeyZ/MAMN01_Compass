package com.example.mycompass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button compassButton;
    private Button Buttonacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compassButton = findViewById(R.id.buttonCompass);
        Buttonacc = findViewById(R.id.buttonacc);
        compassButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCompassActivity();
            }
        });
        Buttonacc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAccActivity();
            }
        });
    }

    public void openCompassActivity(){
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }

    public void openAccActivity(){
        Intent intent = new Intent(this, AccelerometerActivity.class);
        startActivity(intent);
    }
}

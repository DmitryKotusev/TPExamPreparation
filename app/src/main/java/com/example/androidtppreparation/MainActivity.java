package com.example.androidtppreparation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button animationButton;
    Button textButton;
    Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationButton = (Button) findViewById(R.id.animationButton);
        textButton = (Button) findViewById(R.id.textButton);
        dateButton = (Button) findViewById(R.id.dateButton);
        animationButton.setOnClickListener(this);
        textButton.setOnClickListener(this);
        dateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.animationButton: {
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            }
            case R.id.textButton: {
                startActivity(new Intent(this, TextFieldsActivity.class));
                break;
            }
            case R.id.dateButton: {
                startActivity(new Intent(this, DateActivity.class));
                break;
            }
            default: {
                break;
            }
        }
    }
}

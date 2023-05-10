package com.example.latihanuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveActivity2 = findViewById(R.id.btn_activity2);
        btnMoveActivity2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_move_activity){
                Intent moveIntent = new Intent(MainActivity.this, ListPahlawanActivity.class);
                startActivity(moveIntent);
        }else if(v.getId() == R.id.btn_activity2) {
                   Intent moveInten2 = new Intent(MainActivity.this, SharedPreferenceActivity.class);
                   startActivity(moveInten2);
        }

    }
}


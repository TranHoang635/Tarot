package com.candles.tarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends MainActivity3 {

    TextView txtHienthithongdiep;
    Button btnRut, btnQuaylai;

//    View.OnClickListener sukienthu2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
    }

    private void addControls() {
        btnRut = findViewById(R.id.btnRut);
        txtHienthithongdiep = findViewById(R.id.txtHienthithongdiep);
    }

    private void addEvents() {
        btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
//        sukienthu2 = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if ( view.getId() == R.id.btnRut){
//                    txtHienthithongdiep.setText("THÔNG ĐIỆP ĐÃ HIỂN THỊ");
//                }
//            }
//        };
    }
}
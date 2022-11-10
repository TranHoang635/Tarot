package com.candles.tarot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button btn_rut, btn_cancel;
    TextView txtHienthi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_rut = (Button) findViewById(R.id.btn_Rut);
        btn_rut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_tarot();
            }
        });
    }

//-------------layout dialog_tarot----------------//
    private void Dialog_tarot(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_tarot);
//        txtHienthi = (TextView) dialog.findViewById(R.id.txtHienthithongdiep);
//        txtHienthi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.setContentView();
//            }
//        });

//        btn_rut = (Button) dialog.findViewById(R.id.btn_Rut);
//        btn_rut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btn_rut.setText("HIỂN THỊ THÔNG ĐIỆP Ở ĐÂY!!!!");
//            }
//        });
        btn_cancel = (Button) dialog.findViewById(R.id.btn_Cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
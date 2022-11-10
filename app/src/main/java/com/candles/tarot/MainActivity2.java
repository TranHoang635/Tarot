package com.candles.tarot;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.collect.Lists;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.PropertyName;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button btn_rut, btn_cancel;
    TextView txtHienthi;
    DatabaseReference mData;
    TextView txtHienthithongdiep;
    ImageView imageView4;
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
        txtHienthithongdiep = (TextView) findViewById(R.id.txtHienthithongdiep);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("Tarot").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                List<DataSnapshot> snapshotList = Lists.newArrayList(task.getResult().getChildren());
                DataSnapshot snapshot = snapshotList.get(new Random().nextInt(snapshotList.size() - 1));

                Tarot tarot = snapshot.getValue(Tarot.class);
                txtHienthithongdiep.setText(tarot.content);
                Picasso.get().load(tarot.image).into(imageView4);
            }
        });


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

class Tarot {
    @PropertyName("content")
    public String content;

    @PropertyName("img")
    public String image;
}
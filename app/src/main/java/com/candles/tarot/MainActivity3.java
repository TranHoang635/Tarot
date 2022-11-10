package com.candles.tarot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.collect.Lists;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.PropertyName;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    DatabaseReference mData;
    TextView txtHienthi;
    ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtHienthi = (TextView) findViewById(R.id.txtHienthithongdiep);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("Tarots").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                List<DataSnapshot> snapshotList = Lists.newArrayList(task.getResult().getChildren());

                DataSnapshot snapshot = snapshotList.get(new Random().nextInt(snapshotList.size() -1));
                Tarot tarot = snapshot.getValue(Tarot.class);
                txtHienthi.setText(tarot.content);
                Picasso.get().load(tarot.image).into(imageView4);
            }
        });

    }

    public void btnQuaylai(View view) {
        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);
    }
}

class Tarot {
    @PropertyName("content")
    public String content;

    @PropertyName("img")
    public String image;
}
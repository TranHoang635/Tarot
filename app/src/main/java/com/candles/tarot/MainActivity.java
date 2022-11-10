package com.candles.tarot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_join, btn_exit;
    TextView txthienThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!skdfjhksdfjsldkjf");

    }

    private void addEvent() {
        //-------------button exit-------------//
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(1);
            }
        });

        //-------------button join-------------//
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Đã vào tarot ! hãy thử rút một lá bài.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        btn_join = findViewById(R.id.btn_join);
        btn_exit = findViewById(R.id.btn_exit);

    }
}


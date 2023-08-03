package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class l2 extends AppCompatActivity {
    TextView txt2, txt3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l2);

        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button2);
        Intent i = getIntent();
        String username = i.getStringExtra("name");
        int random = generaterandom();
        txt3.setText("" + random);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(username,random);
            }
        });

    }

    public int generaterandom() {
        Random rand = new Random();
        int no = rand.nextInt(100);
        return no;
    }

    public void share(String username, int random) {


        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String num=String.valueOf(random);
        i.putExtra(Intent.EXTRA_SUBJECT, username+ "got a lucky number today");
        i.putExtra(Intent.EXTRA_TEXT, "his lucky no. is "+num);
        startActivity(Intent.createChooser(i, "choose"));
    }

    }


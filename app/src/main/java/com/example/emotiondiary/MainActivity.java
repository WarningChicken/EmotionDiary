package com.example.emotiondiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str;

        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "user.txt"));
            str = br.readLine();
        }catch(Exception e){
            str = e.toString();
        }


        TextView textView = (TextView)findViewById(R.id.testtxt);
        textView.setText(str);
    }
}

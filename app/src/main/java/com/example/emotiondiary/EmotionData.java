package com.example.emotiondiary;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;

import static java.lang.Integer.valueOf;

public class EmotionData {
    public SimpleDateFormat dateFormat;
    public Color color;
    public int eCode;  //Emotion Code
    public String[] sWord = new String[4];

    @RequiresApi(api = Build.VERSION_CODES.O)
    public EmotionData(String data){
        String[] str = data.split(":");
        this.dateFormat = new SimpleDateFormat(str[0]);
        this.color = Color.valueOf(Color.parseColor("#" + str[1]));
        this.eCode = Integer.parseInt(str[2]);
        this.sWord[0] = str[3];
        this.sWord[1] = str[4];
        this.sWord[2] = str[5];
        this.sWord[3] = str[6];
    }
}

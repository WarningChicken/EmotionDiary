package com.example.emotiondiary;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.View;

import com.example.emotiondiary.EmotionData;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


//import android.support.annotation.Nullable;

public class Fragment3 extends Fragment {
    List<EmotionData> eList = new ArrayList<>();



    //Fragment of month_view
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month_view, container, false);

        TextView textView = (TextView)view.findViewById(R.id.text_month);
        try {
            BufferedReader br = new BufferedReader(new FileReader(getContext().getFilesDir() + "data.txt"));
            String str;
            while((str = br.readLine()) != null){
                eList.add(new EmotionData(str));
            }
        }catch(Exception e){
            textView.setText(e.toString());
        }


        //아래는 try-catch문은 테스트용 코드! 수정 요망!
        try {
            EmotionData emo;
            Iterator<EmotionData> iter = eList.iterator();
            if(iter.hasNext()){
                emo = iter.next();
            } else
                emo = new EmotionData("19961025:FFDDAA:7:가나:다라:마바:" + getContext().getFilesDir() + "data.txt\"");

            textView.setText(emo.dateFormat.format(new Date()).toString() + emo.color.toString() + emo.sWord[0] + emo.sWord[1] + emo.sWord[2] + emo.sWord[3]);
        }catch (Exception e){
            textView.setText(e.getMessage());
        }

        return view;
    }
}
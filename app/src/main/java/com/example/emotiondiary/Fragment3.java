package com.example.emotiondiary;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.View;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;


//import android.support.annotation.Nullable;

public class Fragment3 extends Fragment {
    List<EmotionData> eList = new ArrayList<>();

    //Fragment of month_view
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month_view, container, false);

        try {
            BufferedReader br = new BufferedReader(new FileReader(getContext().getFilesDir() + "data.txt"));
            String str;
            while((str = br.readLine()) != null)
                eList.add(new EmotionData(str));
        }catch (Exception e){
            //textView.setText(e.getMessage());
        }

        final TextView textView = (TextView)view.findViewById(R.id.textView3);
        final int[][] arrays = new int[1][3];

        MaterialCalendarView materialCalendarView = (MaterialCalendarView)view.findViewById(R.id.calendarView);

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView, @NonNull CalendarDay calendarDay, boolean b) {
                textView.setText(materialCalendarView.getSelectedDate().toString().substring(12));
                arrays[0] = SortnEmo(eList);
            }
        });
        try {
            ImageView imageView1 = (ImageView) view.findViewById(R.id.imageView1);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView2);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView3);
            switch (arrays[0][0]) {
                case 0:
                    imageView1.setImageResource(R.drawable.soso1);
                    break;
                case 1:
                    imageView1.setImageResource(R.drawable.happy2);
                    break;
                case 2:
                    imageView1.setImageResource(R.drawable.sad3);
                    break;
                case 3:
                    imageView1.setImageResource(R.drawable.angry4);
                    break;
                case 4:
                    imageView1.setImageResource(R.drawable.love5);
                    break;
                case 5:
                    imageView1.setImageResource(R.drawable.emb6);
                    break;
                case 6:
                    imageView1.setImageResource(R.drawable.cynical7);
                    break;
                case 7:
                    imageView1.setImageResource(R.drawable.confi8);
                    break;
                case 8:
                    imageView1.setImageResource(R.drawable.tired9);
                    break;
            }
            switch (arrays[0][1]) {
                case 0:
                    imageView2.setImageResource(R.drawable.soso1);
                    break;
                case 1:
                    imageView2.setImageResource(R.drawable.happy2);
                    break;
                case 2:
                    imageView2.setImageResource(R.drawable.sad3);
                    break;
                case 3:
                    imageView2.setImageResource(R.drawable.angry4);
                    break;
                case 4:
                    imageView2.setImageResource(R.drawable.love5);
                    break;
                case 5:
                    imageView2.setImageResource(R.drawable.emb6);
                    break;
                case 6:
                    imageView2.setImageResource(R.drawable.cynical7);
                    break;
                case 7:
                    imageView2.setImageResource(R.drawable.confi8);
                    break;
                case 8:
                    imageView2.setImageResource(R.drawable.tired9);
                    break;
            }
            switch (arrays[0][2]) {
                case 0:
                    imageView3.setImageResource(R.drawable.soso1);
                    break;
                case 1:
                    imageView3.setImageResource(R.drawable.happy2);
                    break;
                case 2:
                    imageView3.setImageResource(R.drawable.sad3);
                    break;
                case 3:
                    imageView3.setImageResource(R.drawable.angry4);
                    break;
                case 4:
                    imageView3.setImageResource(R.drawable.love5);
                    break;
                case 5:
                    imageView3.setImageResource(R.drawable.emb6);
                    break;
                case 6:
                    imageView3.setImageResource(R.drawable.cynical7);
                    break;
                case 7:
                    imageView3.setImageResource(R.drawable.confi8);
                    break;
                case 8:
                    imageView3.setImageResource(R.drawable.tired9);
                    break;
            }
        }catch (Exception e) {

        }


                //materialCalendarView.setBackground(Draw);

/*        TextView textView = (TextView)view.findViewById(R.id.text_month);
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
        }*/

        return view;
    }
    public int[] SortnEmo(List<EmotionData> eList){
        Iterator<EmotionData> iter = eList.iterator();

        int[] emo = new int[9];
        for(int i = 0; i < 9; i++){
            emo[i] = 0;
        }

        while(iter.hasNext()){
            emo[iter.next().eCode]++;
        }

        int[] eee = new int[3];
        for(int j = 0; j<3;j++) {
            int max = emo[0];
            int mnum = 0;
            for (int i = 1; i < emo.length; i++) {
                if (max < emo[i]) {
                    max = emo[i];
                    mnum = i;
                }
            }
            eee[j] = mnum;
            emo[mnum] = 0;

        }
        return eee;
    }
}
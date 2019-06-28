package com.example.emotiondiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;


public class ChatActivity extends AppCompatActivity {

    private int today=11111111;
    private int imoticon;
    private String color_code;
    private String keyword1,keyword2,keyword3;


    Emo_alpaPageAnimationListener listener = new Emo_alpaPageAnimationListener();
    Key_alpaPageAnimationListener listener2 = new Key_alpaPageAnimationListener();
    Color_alpaPageAnimationListener listener3 = new Color_alpaPageAnimationListener();


    File txtData;
    ConstraintLayout emotion_pane,color_pane,keyword3_pane,last_pane;
    Animation gone_alpha_anim1,alpha_admin;
    ImageView e1,e2,e3,e4,e5,e6,e7,e8,e9;
    EditText key1,key2,key3;
    ImageButton cbtn1,cbtn2,cbtn3,cbtn4,cbtn5,cbtn6,cbtn7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        txtData = new File(getFilesDir() + "data.txt");

        emotion_pane =  findViewById(R.id.emotion_pane);
        color_pane = findViewById(R.id.color_pane);
        keyword3_pane =findViewById(R.id.keyword3_pane);
        last_pane = findViewById(R.id.last_pane);

        //애니매이션 등록
        gone_alpha_anim1= AnimationUtils.loadAnimation(this,R.anim.alph_animgone);
        alpha_admin =AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
        gone_alpha_anim1.setAnimationListener(listener);


        View.OnClickListener emolistener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.e1:
                        imoticon =1;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e2:
                        imoticon =2;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e3:
                        imoticon =3;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e4:
                        imoticon =4;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e5:
                        imoticon =5;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e6:
                        imoticon =6;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e7:
                        imoticon =7;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e8:
                        imoticon =8;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.e9:
                        imoticon =9;
                        emotion_pane.startAnimation(gone_alpha_anim1);
                        break;
                }
            }

        };

        // 감정 미모티콘 설정
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);
        e9 = findViewById(R.id.e9);

        e1.setOnClickListener(emolistener);
        e2.setOnClickListener(emolistener);
        e3.setOnClickListener(emolistener);
        e4.setOnClickListener(emolistener);
        e5.setOnClickListener(emolistener);
        e6.setOnClickListener(emolistener);
        e7.setOnClickListener(emolistener);
        e8.setOnClickListener(emolistener);
        e9.setOnClickListener(emolistener);

        key1 = findViewById(R.id.keyword1_text);
        key2 =findViewById(R.id.keyword2_text);
        key3 =findViewById(R.id.keyword3_text);

        //키워드 엔드버튼
        ImageView done_btn = findViewById(R.id.done_btn);
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               keyword1 = key1.getText().toString();
               keyword2 = key2.getText().toString();
               keyword3 = key3.getText().toString();
               keyword3_pane.startAnimation(gone_alpha_anim1);
            }
        });

        cbtn1 = findViewById(R.id.cbtn1);
        cbtn2 = findViewById(R.id.cbtn2);
        cbtn3 = findViewById(R.id.cbtn3);
        cbtn4 = findViewById(R.id.cbtn4);
        cbtn5 = findViewById(R.id.cbtn5);
        cbtn6 = findViewById(R.id.cbtn6);
        cbtn7 = findViewById(R.id.cbtn7);

        View.OnClickListener colorlistener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.cbtn1:
                        color_code ="ad2b2b";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.cbtn2:
                        color_code ="f9accf";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.cbtn3:
                        color_code ="93278f";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.cbtn4:
                        color_code ="b3b3b3";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.cbtn5:
                        color_code ="4a7c4f";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.cbtn6:
                        color_code ="fbb03b";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                    case R.id.cbtn7:
                        color_code ="93a5f9";
                        color_pane.startAnimation(gone_alpha_anim1);
                        break;
                }
            }

        };

        cbtn1.setOnClickListener(colorlistener);
        cbtn2.setOnClickListener(colorlistener);
        cbtn3.setOnClickListener(colorlistener);
        cbtn4.setOnClickListener(colorlistener);
        cbtn5.setOnClickListener(colorlistener);
        cbtn6.setOnClickListener(colorlistener);
        cbtn7.setOnClickListener(colorlistener);


        //쳇팅 엔드버튼
        ImageButton done_btn2 =findViewById(R.id.done_btn2);
        done_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatActivity.this, MainActivity.class));
            }
        });



    }

    class Emo_alpaPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationEnd(Animation animation) {
            emotion_pane.setVisibility(View.GONE);
            keyword3_pane.setVisibility(View.VISIBLE);
            keyword3_pane.startAnimation(alpha_admin);
            gone_alpha_anim1.setAnimationListener(listener2);
        }
    }

    class Key_alpaPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationEnd(Animation animation) {
            keyword3_pane.setVisibility(View.GONE);
            color_pane.setVisibility(View.VISIBLE);
            color_pane.startAnimation(alpha_admin);
            gone_alpha_anim1.setAnimationListener(listener3);
        }
    }

    class Color_alpaPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationEnd(Animation animation) {
            color_pane.setVisibility(View.GONE);
            last_pane.setVisibility(View.VISIBLE);
            last_pane.startAnimation(alpha_admin);
        }
    }


    void writeDeta(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "data.txt"));
            bw.write(today+":"+color_code+":"+imoticon+":"+keyword1+":"+keyword2+":"+keyword3+":"+"\n"); // user_character --> 0~3 (default == 0)
            bw.close();
        } catch (Exception e) {
            finishAffinity();
        }
    }
}

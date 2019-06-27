package com.example.emotiondiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegisterActivity extends AppCompatActivity {

    String user_name;
    String avatar_name;
    int user_birthday;
    int user_character = 0;

    Animation trans_left,alpha_anim;
    ConstraintLayout notice,register;

    SlidingPageAnimationListener listener =new SlidingPageAnimationListener();
    alpaPageAnimationListener listener2 = new alpaPageAnimationListener();

    ImageView ch0;
    ImageView ch1;
    ImageView ch2;
    ImageView ch3;


    void switchCharacter(int x){
        switch (x) {
            case 0:
                ch0.setImageResource(R.drawable.man0);
                ch1.setImageResource(R.drawable.girln1);
                ch2.setImageResource(R.drawable.mann2);
                ch3.setImageResource(R.drawable.girln3);
                user_character =0;
                break;
            case 1:
                ch0.setImageResource(R.drawable.mann0);
                ch1.setImageResource(R.drawable.girl1);
                ch2.setImageResource(R.drawable.mann2);
                ch3.setImageResource(R.drawable.girln3);
                user_character =1;
                break;
            case 2:
                ch0.setImageResource(R.drawable.mann0);
                ch1.setImageResource(R.drawable.girln1);
                ch2.setImageResource(R.drawable.man2);
                ch3.setImageResource(R.drawable.girln3);
                user_character =2;
                break;
            case 3:
                ch0.setImageResource(R.drawable.mann0);
                ch1.setImageResource(R.drawable.girln1);
                ch2.setImageResource(R.drawable.mann2);
                ch3.setImageResource(R.drawable.girl3);
                user_character =3;
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        notice =  findViewById(R.id.notice);
        register = findViewById(R.id.register);
        trans_left = AnimationUtils.loadAnimation(this, R.anim.trans_left);
        alpha_anim = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);

        //버튼 클릭시 애니매이션 실행
        ImageButton btn_notice = (ImageButton) findViewById(R.id.next_btn);
        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.startAnimation(trans_left);
            }
        });
        trans_left.setAnimationListener(listener);
        alpha_anim.setAnimationListener(listener2);

        final EditText name_edit =(EditText) findViewById(R.id.edit_name_text);
        final EditText birth_edit=(EditText) findViewById(R.id.edit_birth_text);

        name_edit.setCursorVisible(false);
        birth_edit.setCursorVisible(false);

        ch0  =(ImageView)findViewById(R.id.ch0);
        ch1  =(ImageView)findViewById(R.id.ch1);
        ch2  =(ImageView)findViewById(R.id.ch2);
        ch3  =(ImageView)findViewById(R.id.ch3);


        //아바타 이미지 클릭시 변경
        ch0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchCharacter(0);
            }
        });

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchCharacter(1);
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchCharacter(2);
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchCharacter(3);
            }
        });

        ImageButton btn_register = (ImageButton) findViewById(R.id.register_btn);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name = name_edit.getText().toString();
                String user_birthday_check = birth_edit.getText().toString();

                if( (user_name.getBytes().length <= 0) || (user_birthday_check.getBytes().length <= 7)){
                    Toast.makeText(getApplicationContext(),"입력 하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    user_birthday = Integer.parseInt(user_birthday_check);
                    //setUserData();
                    Toast.makeText(getApplicationContext(),"정상 등록되었습니다.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }

            }
        });
    }

    public void setUser_Data(){
     File userInfo = new File(getFilesDir() + "user.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "user.txt"));
            bw.write(user_name+":"+user_birthday+":"+user_character+":"+avatar_name+"\n"); // user_character --> 0~3
            bw.close();
        } catch (Exception e) {
            finishAffinity();
        }
    }

    class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationEnd(Animation animation) {
            register.startAnimation(alpha_anim);
            notice.setVisibility(View.INVISIBLE);
        }
    }

    class alpaPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationEnd(Animation animation) {
            register.setVisibility(View.VISIBLE);
        }
    }

}


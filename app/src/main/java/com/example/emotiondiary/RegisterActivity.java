package com.example.emotiondiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegisterActivity extends AppCompatActivity {

    String user_name;
    String sex;
    int user_birthday;
    int user_character;

    Animation trans_left;
    ConstraintLayout notice;

    SlidingPageAnimationListener listener =new SlidingPageAnimationListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        notice =  findViewById(R.id.notice);
        trans_left = AnimationUtils.loadAnimation(this, R.anim.trans_left);

        ImageButton btn = (ImageButton) findViewById(R.id.next_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.startAnimation(trans_left);
            }
        });

        trans_left.setAnimationListener(listener);



    }

    public void setUser_Data(){
     File userInfo = new File(getFilesDir() + "user.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "user.txt"));
            bw.write(user_name+":"+sex+":"+user_birthday+":"+user_character+"\n");
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
            notice.setVisibility(View.INVISIBLE);
        }
    }

}


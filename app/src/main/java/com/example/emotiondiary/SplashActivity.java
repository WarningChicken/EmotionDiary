package com.example.emotiondiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        * 파일 시스템 구현 필요
        * */
        try {
            Thread.sleep(4000); // 4초간 슬립
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        /*
        파일 시스템에 이미 존해하면 RegisterPage 에는 들어가지 못하도록 구동 필요
         */
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

package com.example.emotiondiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //감정 데이터 없으면 생성
        File txtData = new File(getFilesDir() + "data.txt");
        if (!txtData.isFile()) {
            try {
                txtData.createNewFile();
            } catch (Exception e) {
                finishAffinity();
            }
        }


        try {
            Thread.sleep(1000); // 1초간 슬립
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File userInfo = new File(getFilesDir() + "user.txt");
        if (!userInfo.isFile()) {
            //회원 정보 파일 없으면 회원정보 입력 Activity로 이동
            startActivity(new Intent(this, RegisterActivity.class));
            /*
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "user.txt"));
                bw.write("박준화:남:19961025\n");
                bw.close();
            } catch (Exception e) {
                finishAffinity();
            }*/
        }else{
            startActivity(new Intent(this, MainActivity.class));
        }

        /*
        파일 시스템에 이미 존해하면 RegisterPage 에는 들어가지 못하도록 구동 필요
         */
        finish();
    }
}

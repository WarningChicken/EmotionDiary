package com.example.emotiondiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt1,bt2,bt3, bt4;
    Fragment1 frag1;
    Fragment2 frag2;
    Fragment3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*        RegisterActivity MA = (RegisterActivity)RegisterActivity._RegisterActivity;
        MA.finish();*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        frag1 = new Fragment1(); //프래그먼트 객채셍성
        frag2 = new Fragment2(); //프래그먼트 객채셍성
        frag3 = new Fragment3(); //프래그먼트 객채셍성
        setFrag(0); //프래그먼트 교체
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt1:
                setFrag(0);
                break;
            case R.id.bt2:
                setFrag(1);
                break;
            case R.id.bt3:
                setFrag(2);
                break;
            case R.id.bt4:
                startActivity(new Intent(this, ChatActivity.class));
                break;
        }
    }
    public void setFrag(int n){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
        }
    }
}
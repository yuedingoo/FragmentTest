package com.example.yueding.fragmenttest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_setting;
    private TextView txt_my;

    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        bindViews();
        txt_channel.performClick();
    }

    private  void bindViews(){
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_my = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);

        txt_setting.setOnClickListener(this);
        txt_my.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_channel.setOnClickListener(this);
    }

    private void hideAllFragment(FragmentTransaction fTransaction){
        if (fg1 != null){fTransaction.hide(fg1);}
        if (fg2 != null){fTransaction.hide(fg2);}
        if (fg3 != null){fTransaction.hide(fg3);}
        if (fg4 != null){fTransaction.hide(fg4);}
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()){
            case R.id.txt_channel:
                unSelected();
                txt_channel.setSelected(true);
                if (fg1 == null){
                    fg1 = new MyFragment("第一个Fragment");
                    transaction.add(R.id.ly_content, fg1);
                } else {
                    transaction.show(fg1);
                }
                break;
            case R.id.txt_message:
                unSelected();
                txt_message.setSelected(true);
                if (fg2 == null){
                    fg2 = new MyFragment("第二个Fragment");
                    transaction.add(R.id.ly_content, fg2);
                } else {
                    transaction.show(fg2);
                }
                break;
            case R.id.txt_better:
                unSelected();
                txt_my.setSelected(true);
                if (fg3 == null){
                    fg3 = new MyFragment("第三个Fragment");
                    transaction.add(R.id.ly_content, fg3);
                } else {
                    transaction.show(fg3);
                }
                break;
            case R.id.txt_setting:
                unSelected();
                txt_setting.setSelected(true);
                if (fg4 == null){
                    fg4 = new MyFragment("第四个Fragment");
                    transaction.add(R.id.ly_content, fg4);
                } else {
                    transaction.show(fg4);
                }
                break;
        }

        transaction.commit();
    }

    private void unSelected() {
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_setting.setSelected(false);
        txt_my.setSelected(false);
    }
}

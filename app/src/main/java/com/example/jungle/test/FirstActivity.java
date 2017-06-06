package com.example.jungle.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jungle.test.base.SwipebackLayoutBaseActivity;

public class FirstActivity extends SwipebackLayoutBaseActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_first);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        findViewById(R.id.go_to_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }
}

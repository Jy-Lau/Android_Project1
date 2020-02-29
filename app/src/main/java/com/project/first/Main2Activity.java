package com.project.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1=findViewById(R.id.textview1);
        btn=findViewById(R.id.btn_1);
        btn.setOnClickListener(this);
        String s=getIntent().getStringExtra(MainActivity.KEY_NAME);
        textView1.setText(s);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.putExtra(MainActivity.KEY_NAME,"Hi from Activity 2");
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}

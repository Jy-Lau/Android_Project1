package com.project.first;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1;
    Button btn1;
    Button btn2;
    EditText editText;
    public static String KEY_NAME = "KEY";
    static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference component form ID
        textView1 = findViewById(R.id.textview1); //textview
        btn1 = findViewById(R.id.btn_1);//button 1
        btn2=findViewById(R.id.btn_2); //button 2
        editText = findViewById(R.id.edittext1); //edit text

        textView1.setText("From MainActivity"); //set text on textView1
        btn1.setOnClickListener(this);  //set onClick Listener on button 1
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_1:
                Intent i = new Intent(this, Main2Activity.class);
                i.putExtra(KEY_NAME, editText.getText().toString());
                startActivityForResult(i, REQUEST_CODE);
                //switch to next activity and expect to receive result later
                break;
            case R.id.btn_2:
                Intent p = new Intent(this, Main3Activity.class);
                startActivity(p);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                textView1.setText(data.getStringExtra(KEY_NAME));
            }
        }
    }
}

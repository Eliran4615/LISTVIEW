package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et1,et2;
    RadioGroup rg;
    RadioButton rb1, rb2;
    double a1,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.a1);
        et2 = (EditText) findViewById(R.id.d);
        rg = (RadioGroup) findViewById(R.id.rgroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rg.check(R.id.radioButton);
    }

    public void calculate(View view) {
        if (!(et1.getText().toString().equals("")) && !(et2.getText().toString().equals(""))) {
            a1 = Double.parseDouble(et1.getText().toString());
            d = Double.parseDouble(et2.getText().toString());
            if (rg.getCheckedRadioButtonId() == R.id.radioButton){
                Intent si = new Intent(this, MainActivity2.class);
                si.putExtra("type_series","arithmetic");
                si.putExtra("a1",a1);
                si.putExtra("d",d);
                startActivity(si);
            }
            else if (rg.getCheckedRadioButtonId() == R.id.radioButton2) {
                Intent si = new Intent(this, MainActivity2.class);
                si.putExtra("type_series","geometric");
                si.putExtra("a1",a1);
                si.putExtra("d",d);
                startActivity(si);
            }
        }
        else
            Toast.makeText(this, "answer all the fields", Toast.LENGTH_LONG).show();
    }
}

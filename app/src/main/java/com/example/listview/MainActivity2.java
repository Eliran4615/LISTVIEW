package com.example.listview;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String type_of_series;
    double a1,d,sn;
    ListView lv;
    TextView tv1, tv2, tv3,tv4;
    ArrayAdapter<Double> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textView5);
        tv2 = (TextView) findViewById(R.id.textView7);
        tv3 = (TextView) findViewById(R.id.textView9);
        tv4 = (TextView) findViewById(R.id.textView11);
        lv = findViewById(R.id.listV);

        Intent gi = getIntent();
        type_of_series = gi.getStringExtra("type_series");
        a1 = gi.getDoubleExtra("a1",-999999);
        d = gi.getDoubleExtra("d",-999999);

        tv1.setText(""+ a1);
        tv2.setText(""+d);

        Double[] arry = new Double[20];
        if (type_of_series.equals("arithmetic")){
            for (int i = 0; i < arry.length; i++) {
                arry[i] = a1 + (i * d);
            }
        }
        else{
            for (int i = 0; i < arry.length; i++) {
                arry[i] = a1 * Math.pow(d,(i));
            }
        }
        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arry);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv3.setText(""+(position+1) );
        if(type_of_series.equals("arithmetic")){
            sn=((2*a1+(d*position))*(position+1))/2;
        }
        else {
            if (d==1){
                sn = (position+1)*a1;
            }
            else{
                sn = a1*((Math.pow(d,(position+1))-1)/(d-1));
            }
        }
        tv4.setText(""+sn);
    }
}
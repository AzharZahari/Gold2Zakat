package com.example.goldzakat;

import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        float total_value = 0, tgv = 0, r=0 , cv = 0, w= 0;
        double  zakatpayable = 0,totalzakat = 0;

        Intent intent = getIntent();
        w = intent.getFloatExtra("weight", 0);
        r = intent.getFloatExtra("checked",0);
        cv = intent.getFloatExtra("currentValue", 0);

        if (r == 1){
            tgv = w - 85;
        }else if(r == 2){
            tgv = w - 200;
        }


        total_value = w * cv;

        zakatpayable = tgv * cv;

        totalzakat = zakatpayable * 0.025;


        TextView totalValue = (TextView) findViewById(R.id.totalValue);
        TextView zakatPayable = (TextView) findViewById(R.id.zakatPayable);
        TextView totalZakat = (TextView) findViewById(R.id.totalZakat);

        totalValue.setText("TOTAL VALUE : RM" + total_value);
        zakatPayable.setText("ZAKAT PAYABLE : RM" + zakatpayable);
        totalZakat.setText("TOTAL ZAKAT : RM" + totalzakat);
    }
}

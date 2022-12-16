package com.example.goldzakat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class input extends AppCompatActivity {
    EditText weight;
    EditText current;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        weight =(EditText)findViewById(R.id.Weight);
        current =(EditText)findViewById(R.id.currentValue);
        RadioGroup x =findViewById(R.id.radioGroup);
        Button reset=(Button)findViewById(R.id.btnreset);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                weight.setText(" ");
                current.setText(" ");
                x.clearCheck();


            }
        });

        Button getValue = (Button) findViewById(R.id.getValue);
        getValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton Keep = (RadioButton) findViewById(R.id.Keep);
                RadioButton Wear = (RadioButton) findViewById(R.id.Wear);


                Float w = null;
                try{
                    w = new Float(weight.getText().toString());
                }catch(Exception ignore){
                    Toast.makeText(input.this, "please fill the weight", Toast.LENGTH_LONG).show();
                }

                Float cv = null;
                try{
                    cv = new Float(current.getText().toString());
                }catch(Exception ignore){
                    Toast.makeText(input.this, "please fill the weight", Toast.LENGTH_LONG).show();
                }



                float checked = 0;
                if (Keep.isChecked()) {
                    checked = 1;
                } else if (Wear.isChecked()) {
                    checked = 2;
                }




                Intent intent = new Intent(getApplicationContext(), output.class);
                intent.putExtra("weight", w);
                intent.putExtra("checked", checked);
                intent.putExtra("currentValue", cv);
                startActivity(intent);
            }
        });
    }






    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                //page link
                Intent i = new Intent(this, about.class);
                startActivity(i);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

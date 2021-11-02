package com.example.unitconverterpotraitlandscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    EditText input1;
    TextView view1;
    Button button;
    Map<String, Double> lookup = new HashMap<String, Double>(){{put("Tonne", 1e+6);
        put("Kilogram", 1000.0);
        put("Gram", 1.0);
        put("Milligram", 0.001);
        put("Microgram", 1e-6);
        put("Imperial Ton", 1.016e+6);
        put("Pound", 453.592);
        put("Ounce", 28.3495);}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportActionBar().hide();
        }
        //activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.mass_user_choices, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.mass_user_choices, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        input1 = (EditText)findViewById(R.id.input1);
        view1 = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.button);
    }


    public void onClickButton(View view){
        String[] units = getResources().getStringArray(R.array.mass_user_choices);
        view1.setText(String.valueOf(Double.parseDouble(String.valueOf(input1.getText())) * lookup.get(spinner1.getSelectedItem()) / lookup.get(spinner2.getSelectedItem())));
    }
}
package com.example.resistorapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinB1, spinB2, spinM, spinT;
    TextView Result, band1, band2, bandMulti, bandTol;
    Button btnCalc, Reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //logic
        spinB1 = findViewById(R.id.Band1);
        spinB2 = findViewById(R.id.band2);
        spinM = findViewById(R.id.band3);
        spinT = findViewById(R.id.band4);
        Result = findViewById(R.id.Result);
        Reset = findViewById(R.id.btnReset);

        //image
        band1 = findViewById(R.id.rectband1);
        band2 = findViewById(R.id.rectband2);
        bandMulti = findViewById(R.id.rectM);
        bandTol = findViewById(R.id.rectTol3);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getTextArray(R.array.Bands)) {
            @NonNull
            @Override
            //to set the background color of the current selected item in the spinner
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setBackgroundColor(ItemBackgroundBand(position));
                if (parent == spinB1)
                {
                    band1.setBackgroundColor(ItemBackgroundBand(position));
                }
                else
                {
                    band2.setBackgroundColor(ItemBackgroundBand(position));
                }
                return view;
            }
            //to set the background color of the other items
            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                view.setBackgroundColor(ItemBackgroundBand(position));
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getTextArray(R.array.Multiplier)) {
            @NonNull
            @Override
            //to set the background color of the current selected item in the spinner
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setBackgroundColor(ItemBackgroundMulti(position));
                bandMulti.setBackgroundColor(ItemBackgroundMulti(position));
                return view;
            }
            //to set the background color of the other items
            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                view.setBackgroundColor(ItemBackgroundMulti(position));
                return view;
            }
        };
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getTextArray(R.array.Tolerance)) {
            @NonNull
            @Override
            //to set the background color of the current selected item in the spinner
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setBackgroundColor(ItemBackgroundTol(position));
                bandTol.setBackgroundColor(ItemBackgroundTol(position));
                return view;
            }
            //to set the background color of the other items
            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                view.setBackgroundColor(ItemBackgroundTol(position));
                return view;
            }
        };
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinB1.setAdapter(adapter);
        spinB2.setAdapter(adapter);
        spinM.setAdapter(adapter2);
        spinT.setAdapter(adapter3);

        btnCalc = findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b1,b2,m, resistance; String t;

                b1 = BandColor(spinB1.getSelectedItem().toString());
                b2 = BandColor(spinB2.getSelectedItem().toString());
                m = BandMulti(spinM.getSelectedItem().toString());
                t = BandTolerance(spinT.getSelectedItem().toString());
                if (m == 0){
                    resistance = b1 + b2;
                }
                else {
                    resistance = ((b1 * m) + b2) * m;
                }

                Result.setText(String.valueOf(resistance) + "Ω " + t);

            }
        });
    }
    private int ItemBackgroundBand(int position) {
        int[] colors = {R.color.black, R.color.black, R.color.brown, R.color.red, R.color.orange, R.color.yellow,
                R.color.green, R.color.blue, R.color.violet, R.color.gray, R.color.white};

        if (position >= 1 && position < colors.length) {
            return ContextCompat.getColor(this, colors[position]);
        }
        else
        {
            return Color.TRANSPARENT;
        }
    }
    private int ItemBackgroundMulti(int position) {
        int[] colors = {R.color.black, R.color.black, R.color.brown, R.color.red, R.color.orange, R.color.yellow,
                R.color.green, R.color.blue, R.color.violet, R.color.gray, R.color.white, R.color.gold, R.color.silver};

        if (position >= 1 && position < colors.length) {
            return ContextCompat.getColor(this, colors[position]);
        }
        else
        {
            return Color.TRANSPARENT;
        }
    }
    private int ItemBackgroundTol(int position) {
        int[] colors = {R.color.brown, R.color.brown, R.color.red,
                R.color.green, R.color.blue, R.color.violet, R.color.gray, R.color.gold, R.color.silver};

        if (position >= 1 && position < colors.length) {
            return ContextCompat.getColor(this, colors[position]);
        }
        else
        {
            return Color.TRANSPARENT;
        }
    }
    public void reset(View v){

        spinB1.setSelection(0);
        spinB2.setSelection(0);
        spinT.setSelection(0);
        spinM.setSelection(0);
        Result.setText("");
    }

    public Integer BandColor(String color){
        Integer band;
        switch (color){
            case "Black":
                band = 0;
                break;
            case "Brown":
                band = 1;
                break;
            case "Red":
                band = 2;
                break;
            case "Orange":
                band = 3;
                break;
            case "Yellow":
                band = 4;
                break;
            case "Green":
                band = 5;
                break;
            case "Blue":
                band = 6;
                break;
            case "Violet":
                band = 7;
                break;
            case "Gray":
                band = 8;
                break;
            case "White":
                band = 9;
                break;
            default:
                band=0;
        }
        return band;
    }
    public Integer BandMulti(String color){
        Integer band;

        switch (color){
            case "Black":
                band = 1;
                break;
            case "Brown":
                band = 10;
                break;
            case "Red":
                band = 100;
                break;
            case "Orange":
                band = 1000;
                break;
            case "Yellow":
                band = 10000;
                break;
            case "Green":
                band = 100000;
                break;
            case "Blue":
                band = 1000000;
                break;
            case "Violet":
                band = 10000000;
                break;
            case "Gray":
                band = 100000000;
                break;
            case "White":
                band = 1000000000;
                break;
            case "Gold":
                band = (int) 0.1;
                break;
            case "Silver":
                band = (int) 0.01;
                break;
            default:
                band=0;
        }
        return band;
    }
    public String BandTolerance(String color){
        String tolerance;

        switch(color){
            case "Brown":
                tolerance = "±1%";
                break;
            case "Red":
                tolerance = "±2%";
                break;
            case "Green":
                tolerance = "±0.5%";
                break;
            case "Blue":
                tolerance = "±0.25%";
                break;
            case "Violet":
                tolerance = "±0.1%";
                break;
            case "Gray":
                tolerance = "±0.05%";
                break;
            case "Gold":
                tolerance = "±5%";
                break;
            case "Silver":
                tolerance = "±10%";
                break;
            default:
                tolerance= "±20%";
                break;
        }
        return tolerance;
    }

}
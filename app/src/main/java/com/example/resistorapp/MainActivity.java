package com.example.resistorapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //EditText band1, band2, bandMulti, bandTol;
    Spinner spin1, spin2, spin3, spin4;
    //TextView Result;
    Button btnCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1 = findViewById(R.id.Band1);
        spin2 = findViewById(R.id.band2);
        spin3 = findViewById(R.id.band3);
        spin4 = findViewById(R.id.band4);
        String[] colorsBands = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White"};
        String[] colorsMulti = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White", "Silver", "Gold"};
        String[] colorsTol ={"Brown", "Red", "Green", "Blue", "Violet", "Gray","Silver", "Gold"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colorsBands) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Set text color to white
                // Set background color for each item based on the associated color
                String colorName = getItem(position);
                int color = getColorValue(colorName); // Define a method to get the color value based on the color name
                view.setBackgroundColor(color); // Set the background color
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Set text color to white
                // Set background color for each dropdown item based on the associated color
                String colorName = getItem(position);
                int color = getColorValue(colorName); // Define a method to get the color value based on the color name
                view.setBackgroundColor(color); // Set the background color for dropdown items
                return view;
            }

            // Define a method to get the color value based on the color name
            private int getColorValue(String colorName) {
                int color;
                switch (colorName) {
                    case "Black":
                        color = Color.parseColor("#FF000000");
                        break;
                    case "Brown":
                        color = Color.parseColor("#FFA52A2A");
                        break;
                    case "Red":
                        color = Color.parseColor("#FFFF0000");
                        break;
                    case "Orange":
                        color = Color.parseColor("#FFFFA500");
                        break;
                    case "Yellow":
                        color = Color.parseColor("#FFFFFF00");
                        break;
                    case "Green":
                        color = Color.parseColor("#FF008000");
                        break;
                    case "Blue":
                        color = Color.parseColor("#FF0000FF");
                        break;
                    case "Violet":
                        color = Color.parseColor("#FF8A2BE2");
                        break;
                    case "Gray":
                        color = Color.parseColor("#FF808080");
                        break;
                    case "Gold":
                        color = Color.parseColor("#FFD4AF37");
                        break;
                    case "Silver":
                        color = Color.parseColor("#FFC0C0C0");
                        break;
                    default:
                        color = Color.BLACK; // Default color if the colorName does not match any cases
                }
                return color;
            }

        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colorsMulti) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Set text color to white
                // Set background color for each item based on the associated color
                String colorName = getItem(position);
                int color = getColorValue(colorName); // Define a method to get the color value based on the color name
                view.setBackgroundColor(color); // Set the background color
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Set text color to white
                // Set background color for each dropdown item based on the associated color
                String colorName = getItem(position);
                int color = getColorValue(colorName); // Define a method to get the color value based on the color name
                view.setBackgroundColor(color); // Set the background color for dropdown items
                return view;
            }

            // Define a method to get the color value based on the color name
            private int getColorValue(String colorName) {
                int color;
                switch (colorName) {
                    case "Black":
                        color = Color.parseColor("#FF000000");
                        break;
                    case "Brown":
                        color = Color.parseColor("#FFA52A2A");
                        break;
                    case "Red":
                        color = Color.parseColor("#FFFF0000");
                        break;
                    case "Orange":
                        color = Color.parseColor("#FFFFA500");
                        break;
                    case "Yellow":
                        color = Color.parseColor("#FFFFFF00");
                        break;
                    case "Green":
                        color = Color.parseColor("#FF008000");
                        break;
                    case "Blue":
                        color = Color.parseColor("#FF0000FF");
                        break;
                    case "Violet":
                        color = Color.parseColor("#FF8A2BE2");
                        break;
                    case "Gray":
                        color = Color.parseColor("#FF808080");
                        break;
                    case "Gold":
                        color = Color.parseColor("#FFD4AF37");
                        break;
                    case "Silver":
                        color = Color.parseColor("#FFC0C0C0");
                        break;
                    default:
                        color = Color.BLACK; // Default color if the colorName does not match any cases
                }
                return color;
            }

        };
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colorsTol) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Set text color to white
                // Set background color for each item based on the associated color
                String colorName = getItem(position);
                int color = getColorValue(colorName); // Define a method to get the color value based on the color name
                view.setBackgroundColor(color); // Set the background color
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Set text color to white
                // Set background color for each dropdown item based on the associated color
                String colorName = getItem(position);
                int color = getColorValue(colorName); // Define a method to get the color value based on the color name
                view.setBackgroundColor(color); // Set the background color for dropdown items
                return view;
            }

            // Define a method to get the color value based on the color name
            private int getColorValue(String colorName) {
                int color;
                switch (colorName) {
                    case "Black":
                        color = Color.parseColor("#FF000000");
                        break;
                    case "Brown":
                        color = Color.parseColor("#FFA52A2A");
                        break;
                    case "Red":
                        color = Color.parseColor("#FFFF0000");
                        break;
                    case "Orange":
                        color = Color.parseColor("#FFFFA500");
                        break;
                    case "Yellow":
                        color = Color.parseColor("#FFFFFF00");
                        break;
                    case "Green":
                        color = Color.parseColor("#FF008000");
                        break;
                    case "Blue":
                        color = Color.parseColor("#FF0000FF");
                        break;
                    case "Violet":
                        color = Color.parseColor("#FF8A2BE2");
                        break;
                    case "Gray":
                        color = Color.parseColor("#FF808080");
                        break;
                    case "Gold":
                        color = Color.parseColor("#FFD4AF37");
                        break;
                    case "Silver":
                        color = Color.parseColor("#FFC0C0C0");
                        break;
                    default:
                        color = Color.BLACK; // Default color if the colorName does not match any cases
                }
                return color;
            }

        };


        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter2);
        spin4.setAdapter(adapter3);

        btnCalc = findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* int b1,b2,m, resistance; String t, result;
                b1 = BandColor(band1.getText().toString());
                b2 = BandColor(band2.getText().toString());
                m = BandMulti(bandMulti.getText().toString());
                t = BandTolerance(bandTol.getText().toString());

                resistance = ((b1 * m) + b2) * m;

                Result.setText(String.valueOf(resistance) + "Ω " + t);
                */
            }
        });
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
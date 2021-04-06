package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean operatorClicked = true;
    EditText ed;
    String oldNumber = "";
    String selectedOperator = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.txtNumbers);
    }



    public void selectNumber(View v) {

        if(operatorClicked == true){
            ed.setText("");
        }
        operatorClicked = false;

        EditText ed_numbers = (EditText) findViewById(R.id.txtNumbers);
        String numbers = ed_numbers.getText().toString();



        switch (v.getId()) {
            case R.id.btn0:
                numbers = numbers + "0";
                break;
            case R.id.btn1:
                numbers = numbers + "1";
                break;
            case R.id.btn2:
                numbers = numbers + "2";
                break;
            case R.id.btn3:
                numbers = numbers + "3";
                break;
            case R.id.btn4:
                numbers = numbers + "4";
                break;
            case R.id.btn5:
                numbers = numbers + "5";
                break;
            case R.id.btn6:
                numbers = numbers + "6";
                break;
            case R.id.btn7:
                numbers = numbers + "7";
                break;

            case R.id.btn8:
                numbers = numbers + "8";
                break;

            case R.id.btn9:
                numbers = numbers + "9";
                break;

            case R.id.btnPlusMinus:
                if(numbers.charAt(0) == '-'){
                    numbers = numbers.substring(1);
                }else {
                    numbers = "-" + numbers;
                }
                break;

            case R.id.btnDel:
                String updatedNumber = "";
                for(int i=0; i< numbers.length() - 1; i++){
                    updatedNumber += numbers.charAt(i);
                }
                numbers = updatedNumber;
                break;

            case R.id.btnDesi:
                if(numbers.contains(".")) {
                    numbers = numbers ;
                }else{
                    numbers = numbers + ".";
                }
                break;

            case R.id.btnClear:
                numbers = "";
                break;
        }

        ed_numbers.setText(numbers);
    }

    public void operatorEvent(View v){

        operatorClicked = true;
        oldNumber = ed.getText().toString();

        switch(v.getId()){
            case R.id.btnAdd:
                selectedOperator = "+";
                break;

            case R.id.btnSub:
                selectedOperator = "-";
                break;

            case R.id.btnMult:
                selectedOperator = "*";
                break;

            case R.id.btnDiv:
                selectedOperator = "/";
                break;
        }
    }

    public void calculateResult(View v){

        String newNumber = ed.getText().toString();

        double result = 0.0;

        switch (selectedOperator){
            case"+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;

            case"-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;

            case"*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;

            case"/":
                if(newNumber != "0") {
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                }else{
                    result = 0;
                }
                break;
        }

        ed.setText(Double.toString(result));
    }
}
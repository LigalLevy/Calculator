package com.android.ligal.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import static com.android.ligal.calculator.MainActivity.operation.ADD;
import static com.android.ligal.calculator.MainActivity.operation.DIVIDE;
import static com.android.ligal.calculator.MainActivity.operation.MINUS;
import static com.android.ligal.calculator.MainActivity.operation.MULTI;

public class MainActivity extends AppCompatActivity {

    int num1, num2;
    String display = "";
    String calcString = "";
    enum operation {ADD, MINUS, MULTI, DIVIDE}
    operation op;
    TextView calcScreen;
    Button btnAdd, btnMinus, btnMulti, btnDivide, btnClr, btnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

    }

    private void initVariables() {
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMulti = (Button) findViewById(R.id.buttonMulti);
        btnDivide = (Button) findViewById(R.id.buttonDivide);

        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btnClr = (Button) findViewById(R.id.buttonClr);
        calcScreen = (TextView) findViewById(R.id.calcScreen);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(display)){
                    display = String.valueOf(0);
                }
                num1 = Integer.parseInt(display);
                op = ADD;
                display = "";
                calcString += "+";
                calcScreen.setText(calcString);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(display)){
                    display = String.valueOf(0);
                }
                num1 = Integer.parseInt(display);
                op = MINUS;
                display = "";
                calcString += "-";
                calcScreen.setText(calcString);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(display)){
                    display = String.valueOf(0);
                }
                num1 = Integer.parseInt(display);
                op = MULTI;
                display = "";
                calcString += "*";
                calcScreen.setText(calcString);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(display)){
                    display = String.valueOf(0);
                }
                num1 = Integer.parseInt(display);
                op = DIVIDE;
                display = "";
                calcString += "/";
                calcScreen.setText(calcString);
            }
        });

    }

    public void OnClickClear (View view) {
        num1 = 0;
        num2 = 0;
        op = null;
        display = "";
        calcString = "";
        calcScreen.setText("");
    }

    public void onDigitClicked(View view) {
        Button num =  (Button) view;
        calcString += num.getText();
        display += num.getText();
        calcScreen.setText(calcString);

    }

    public void onEqualClicked (View view) {
        num2 = Integer.parseInt(display);
        int result;

        switch (op) {
            case ADD:
                result = num1 + num2;
                display = String.valueOf(result);
                calcScreen.setText(String.valueOf(result));
                break;
            case MINUS:
                result = num1 - num2;
                display = String.valueOf(result);
                calcScreen.setText(String.valueOf(result));
                break;
            case MULTI:
                result = num1 * num2;
                display = String.valueOf(result);
                calcScreen.setText(String.valueOf(result));
                break;
            case DIVIDE:
                try {
                    if (num2 != 0) {
                        result = num1 / num2;
                        display = String.valueOf(result);
                        calcScreen.setText(String.valueOf(result));
                    }
                    else {
                        Toast.makeText(view.getContext(), "Can't Divide by Zero!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex) {
                    calcScreen.setText(ex.getMessage());
                }
                break;
        }

        calcString = calcScreen.getText().toString();
    }


}

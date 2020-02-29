package com.example.calculetor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnAdd, btnSub, btnMul, btnDiv, btnEql,
            btnDot;
    Button btnC;
    TextView tvDisplay, tvHistory;
    double a, b, result;
    // boolean Add, Sub, Mul, Div;

    enum OperationFlag {
        Add, Sub, Mul, Div, NO;
    }

    private OperationFlag flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDot = (Button) findViewById(R.id.btnDot);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEql = (Button) findViewById(R.id.btnEql);
        btnC = (Button) findViewById(R.id.btnC);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        tvHistory = (TextView) findViewById(R.id.tvHistory);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEql.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);

    }  // end of on create method

    int counter = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                setText("0");
                break;
            case R.id.btn1:
                setText("1");
                break;
            case R.id.btn2:
                setText("2");
                break;
            case R.id.btn3:
                setText("3");
                break;
            case R.id.btnAdd:
                a = Double.parseDouble(tvDisplay.getText().toString());
                setText("+");
                setText();
                flag = OperationFlag.Add;
                break;

            case R.id.btnSub:
                a = Double.parseDouble(tvDisplay.getText().toString());
                setText("-");
                setText();
                flag = OperationFlag.Sub;
                break;
            case R.id.btnMul:
                a = Double.parseDouble( tvDisplay.getText().toString());
                setText("*");
                setText();
                flag = OperationFlag.Mul;
                break;
            case R.id.btnEql:
                if (counter == 0)
                    b = Double.parseDouble(tvDisplay.getText().toString());

                ++counter;
                switch (flag) {

                    case Add:
                        result = a + b;
                        break;
                    case Sub:
                        result = a - b;
                        break;
                    case Mul:
                        result = a * b;
                        break;
                    default:
                        setText();
                        setText(b);
                        break;
                }


                setText(result);
                a = Double.parseDouble(tvDisplay.getText().toString());
//                a=b=result=0;
//                flag=OperationFlag.NO;
                break;
        }
    }

    private void setText(Double num) {
        tvDisplay.setText(String.valueOf(num));
        // tvHistory.setText(tvHistory.getText()+num);
    }

    private void setText(String num) {
        tvDisplay.setText(tvDisplay.getText() + num);
        tvHistory.setText(tvHistory.getText() + num);
    }

    private void setText() {
        tvDisplay.setText("");
    }
    private void a(){
        a = Double.parseDouble(tvDisplay.getText().toString());
    }
    private void b(){
        a = Double.parseDouble(tvDisplay.getText().toString());
    }
}

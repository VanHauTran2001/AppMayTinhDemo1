package com.example.appmaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_kq;
     String input;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_kq = (TextView) findViewById(R.id.txt_kq);


    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC" :
                input = "";
                break;
            case "=" :
                TinhToan();
                answer = input;
                break;
            case "+/-" :
                input ="-" + input;
                break;
            default:
                if (input==null){
                    input ="";
                }
                if (data.equals("+")||data.equals("x")||data.equals("-")||data.equals("÷")){
                    TinhToan();
                }
                input += data;
                if(data.equals("%")){
                    if (input.split("%").length==1){
                        String x[] = input.split("%");
                        try {
                            double phanTram = Double.parseDouble(x[0])/100f;
                            input = phanTram + "";
                        }catch (Exception e){

                        }
                    }
                }
        }
        txt_kq.setText(input);
    }
    public void TinhToan(){
            if(input.split("x").length==2){
                String number[] = input.split("x");
                try {
                    double nhan = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                    input = nhan + "";
                }catch (Exception e){

            }
        }
        if(input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try {
                double cong = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = cong + "";
            }catch (Exception e){

            }
        }
        if(input.split("÷").length==2){
            String number[] = input.split("÷");
            try {
                double chia = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = chia + "";
            }catch (Exception e){

            }
        }
        if(input.split("-").length==2){
            String number[] = input.split("-");
            try {
                double tru = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = tru + "";
            }catch (Exception e){

            }
        }
        String n[] = input.split("\\.");
        if(n.length > 1){
            if (n[1].equals("0")){
                input = n[0];
            }
        }
    }
}
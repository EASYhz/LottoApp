package com.example.lottoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int[] myLotto = new int[6];
    public static TextView[] lotto = new TextView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lotto[0] = findViewById(R.id.num1);
        lotto[1] = findViewById(R.id.num2);
        lotto[2] = findViewById(R.id.num3);
        lotto[3] = findViewById(R.id.num4);
        lotto[4] = findViewById(R.id.num5);
        lotto[5] = findViewById(R.id.num6);

        //난수 생성
        RandomNumber();
        //Bubble sort
        BubbleSort();

        for (int i = 0; i < myLotto.length; i++) {
            lotto[i].setText("" + myLotto[i]);
        }
    }


    public static int[] RandomNumber() {
        for(int i = 0; i < myLotto.length; i++ ) {
            myLotto[i] = (int) (Math.random()*45 + 1); // 난수 생성

            //중복 체크
            for(int j = 0; j < i; j++) {
                if(myLotto[j] == myLotto[i]) {
                    i--;
                    break;
                }
            }
        }
        return myLotto;
    }

    public static int[] BubbleSort(){
        for(int i = 0; i < myLotto.length; i++) {
            for (int j = 0; j < myLotto.length - i - 1; j++){
                if (myLotto[j] > myLotto[j+1]){
                    int temp = myLotto[j];
                    myLotto[j] = myLotto[j + 1];
                    myLotto[j + 1] =temp;
                }
            }
        }

        return myLotto;
    }
}

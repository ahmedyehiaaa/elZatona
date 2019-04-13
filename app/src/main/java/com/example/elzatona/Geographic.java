package com.example.elzatona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Geographic extends AppCompatActivity implements View.OnClickListener {

    String[] geographic_questions;
    String[] geographic_answers;
    TextView xx, yy, questions, answers;
    Button back, answer, next;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geographic);

        //Importing the String array  from Values folder
        geographic_questions = getResources().getStringArray(R.array.geographic_questions);
        geographic_answers = getResources().getStringArray(R.array.geographic_answers);

        //intilization of TextView
        xx = findViewById(R.id.xx);
        yy = findViewById(R.id.yy);
        questions = findViewById(R.id.questions);
        answers = findViewById(R.id.answers);

        //intilization of Button
        back = findViewById(R.id.back);
        answer = findViewById(R.id.answer);
        next = findViewById(R.id.next);

        //Onclick Listener for Buttons
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        answer.setOnClickListener(this);

        //Setting Values for TextViews
        index = 0;
        questions.setText(geographic_questions[index]);
        answers.setText("اضغط علي كلمة (الحـل) لكي تظهر لك");
        xx.setText("/" + String.valueOf(index + 1));
        yy.setText(String.valueOf(geographic_questions.length));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.back:
                answers.setText("اضغط علي كلمة (الحـل) لكي تظهر لك");
                index--;
                if (index == -1) {
                    index = geographic_questions.length - 1;

                    questions.setText(geographic_questions[index]);
                    xx.setText("/" + String.valueOf(index + 1));
                } else {

                    questions.setText(geographic_questions[index]);
                    xx.setText("/" + String.valueOf(index + 1));

                }
                break;

            case R.id.answer:
                answers.setText(geographic_answers[index]);
                break;


            case R.id.next:
                answers.setText("اضغط علي كلمة (الحـل) لكي تظهر لك");
                index++;
                if (index == geographic_questions.length) {
                    index = 0;
                    questions.setText(geographic_questions[index]);
                    xx.setText("/" + String.valueOf(index + 1));
                } else {

                    questions.setText(geographic_questions[index]);
                    xx.setText("/" + String.valueOf(index + 1));

                }

                break;
        }
    }
}

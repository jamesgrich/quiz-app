package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        int points = 0;

        // Question 1

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q1_group);
        int buttonId = radioGroup.getCheckedRadioButtonId();

        if (buttonId == -1) {
            Toast.makeText(this, "You must select an answer for question 1", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButton = (RadioButton) findViewById(buttonId);
        String answer = radioButton.getText().toString();
        if (answer.equals("Montreal, Canada")) {
            points++;
        }

        // Question 2 - check that the user has entered at least some text. if not - return

        EditText editText = (EditText) findViewById(R.id.q2_edit_text);
        String answer2 = editText.getText().toString();

        if (answer2.equals("")) {
            Toast.makeText(this, "You must select an answer for question 2", Toast.LENGTH_SHORT).show();
            return;
        }
        if (answer2.equalsIgnoreCase("Stanley Cup")) {
            points++;
        }

        // Question 3 - check the user has selected at least one checkbox. if not return

        CheckBox checkBox = (CheckBox) findViewById(R.id.q3_checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q3_checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q3_checkbox3);

        if (checkBox.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked()) {
            points++;
        }
        else {
                Toast.makeText(this, "You must select an answer for question 3", Toast.LENGTH_SHORT).show();
            }

        // Question 4

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.q4_group);
        int buttonId2 = radioGroup2.getCheckedRadioButtonId();

        if (buttonId2 == -1) {
            Toast.makeText(this, "You must select an answer for question 4", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton radioButton2 = (RadioButton) findViewById(buttonId2);
        String answer4 = radioButton2.getText().toString();

        if (answer4.equals("99")) {
            points++;
        }

        // Question 5

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.q5_group);
        int buttonId3 = radioGroup3.getCheckedRadioButtonId();

        if (buttonId3 == -1) {
            Toast.makeText(this, "You must select an answer for question 5", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButton5 = (RadioButton) findViewById(buttonId3);
        String answer3 = radioButton5.getText().toString();

        if (answer3.equals("11 feet")) {
            points++;
        }

        if (points <= 3) {
            Toast.makeText(this, "Unlucky, you scored " + points + "/5", Toast.LENGTH_SHORT).show();
        }

        if (points >= 3) {
            Toast.makeText(this, "Nice work! You scored " + points + "/5", Toast.LENGTH_SHORT).show();
        }
    }
}

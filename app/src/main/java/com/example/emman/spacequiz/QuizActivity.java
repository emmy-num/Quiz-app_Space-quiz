package com.example.emman.spacequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = new Bundle();
        if (getIntent().getExtras() != null) {
            extras = getIntent().getExtras();
        }
        String name = getString(R.string.candidate) + " " + extras.getString("text");
        TextView textView = findViewById(R.id.name_text);
        textView.setText(name);
    }

    /**
     * This method checks every answer and records whether
     * the user got the question right,and then
     * displays quiz result in a toast message
     *
     * @param view
     */
    public void submitAnswer(View view) {

        //final quiz score
        int totalScore = 0;

        //Records state of checkboxes
        boolean atLeastOneChecked = false;

        //Stores multiple choice answers
        int answerSet = 0;

        //Checks state of question one and records answer
        RadioGroup questionOne = findViewById(R.id.question_1);
        RadioButton answerForQuestionOne = findViewById(R.id.b1_radio_button);
        if (answerForQuestionOne.isChecked()) {
            totalScore += 10;
        } else {
            totalScore += 0;
        }

        //Checks state of question two and records answer
        RadioGroup questionTwo = findViewById(R.id.question_2);
        RadioButton answerForQuestionTwo = findViewById(R.id.c2_radio_button);
        if (answerForQuestionTwo.isChecked()) {
            totalScore += 10;
        } else {
            totalScore += 0;
        }

        //Checks state of question three and records answer
        RadioGroup questionThree = findViewById(R.id.question_3);
        RadioButton answerForQuestionThree = findViewById(R.id.d3_radio_button);
        if (answerForQuestionThree.isChecked()) {
            totalScore += 10;
        } else {
            totalScore += 0;
        }

        //Gets text from Edittext and checks if answer is correct
        EditText editText = findViewById(R.id.question_4_text_field);
        String entryText = editText.getText().toString();

        if (entryText.equals(getString(R.string.question_4_answer))) {
            totalScore += 10;
        } else {
            totalScore += 0;
        }

        //Gets state of all checkboxes and stores their values in a boolean
        CheckBox optionA = findViewById(R.id.question_5_answer_a);
        boolean hasWrongAnswerA = optionA.isChecked();
        CheckBox optionB = findViewById(R.id.question_5_answer_b);
        boolean hasFirstAnswer = optionB.isChecked();
        CheckBox optionC = findViewById(R.id.question_5_answer_c);
        boolean hasWrongAnswerC = optionC.isChecked();
        CheckBox optionD = findViewById(R.id.question_5_answer_d);
        boolean hasSecondAnswer = optionD.isChecked();

        //Sets exact score for multiple choice answers
        if (hasFirstAnswer) {
            answerSet += 1;
        }
        if (hasSecondAnswer) {
            answerSet += 1;
        }
        if (answerSet == 2) {
            totalScore += 10;
        } else {
            totalScore += 0;
        }

        //Returns the identifier of the selected radio button in this group
        //and stores the return value as an integer
        int rb1 = questionOne.getCheckedRadioButtonId();
        int rb2 = questionTwo.getCheckedRadioButtonId();
        int rb3 = questionThree.getCheckedRadioButtonId();

        //Control structure to ensure all questions are answered
        // before displaying toast result message
        if (rb1 == -1) {
            Toast toastMessage = Toast.makeText(this, "Answer all questions", Toast.LENGTH_SHORT);
            toastMessage.show();
        } else if (rb2 == -1) {
            Toast toastMessage = Toast.makeText(this, "Answer all questions", Toast.LENGTH_SHORT);
            toastMessage.show();
        } else if (rb3 == -1) {
            Toast toastMessage = Toast.makeText(this, "Answer all questions", Toast.LENGTH_SHORT);
            toastMessage.show();
        } else if (TextUtils.isEmpty(editText.getText())) {
            editText.setError("Required!");
            Toast toastMessage = Toast.makeText(this, "Answer all questions", Toast.LENGTH_SHORT);
            toastMessage.show();
        } else if (hasWrongAnswerA) {
            atLeastOneChecked = true;
        } else if (hasFirstAnswer) {
            atLeastOneChecked = true;
        } else if (hasWrongAnswerC) {
            atLeastOneChecked = true;
        } else if (hasSecondAnswer) {
            atLeastOneChecked = true;
        } else {
            Toast toastMessage = Toast.makeText(this, "Answer all questions", Toast.LENGTH_SHORT);
            toastMessage.show();
        }
        if (atLeastOneChecked) {
            Toast toastMessage = Toast.makeText(this, "Result: You scored " + totalScore + " out of 50 Space points", Toast.LENGTH_SHORT);
            toastMessage.show();
        }

        //Clears away all selections
        questionOne.clearCheck();
        questionTwo.clearCheck();
        questionThree.clearCheck();
        editText.setText("");
        optionA.setChecked(false);
        optionB.setChecked(false);
        optionC.setChecked(false);
        optionD.setChecked(false);
    }

}



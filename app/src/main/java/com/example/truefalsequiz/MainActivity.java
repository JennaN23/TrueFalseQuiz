package com.example.truefalsequiz;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonTrue;
    private Button buttonFalse;
    private TextView textViewQuestion;
    public static final String FINAL_SCORE = "Your final score is ";
    public static final String TAG = "MainActivity";
    private Quiz quiz;
    private Question currentQuestion;
    private boolean userAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        wireWidgets();

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer = false;
                checkAnswer(false);


            }
        });

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer = true;
                checkAnswer(true);
            }
        });


        InputStream stream = getResources().openRawResource(R.raw.questions);
        String jsonString = readTextFile(stream);


        // create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
// convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
// verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());

    quiz = new Quiz(questionList);

    displayNextQuestion();







    }

    private void checkAnswer(boolean b) {
        if(currentQuestion.checkAnswer(userAnswer)){
            quiz.incrementScore();
            Toast.makeText(this, "Correct!!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Incorrect.", Toast.LENGTH_SHORT).show();
        }
        displayNextQuestion();

    }

    private void displayNextQuestion() {
        if(quiz.isAnotherQuestion()){
            currentQuestion = quiz.nextQuestion();
            textViewQuestion.setText(currentQuestion.getQuestion());
        }
        else
        {
            textViewQuestion.setText("There are no more questions.");
            String finalScore = FINAL_SCORE + String.valueOf(quiz.getScore());
            Intent intentFinalScore = new Intent(MainActivity.this, FinalScoreActivity.class);
            intentFinalScore.putExtra(FINAL_SCORE, finalScore);
            startActivity(intentFinalScore);
        }
    }


    private String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
                try {
                    while ((len = inputStream.read(buf)) != -1) {
                        outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }



    private void wireWidgets() {
        buttonFalse = findViewById(R.id.button_main_false);
        buttonTrue = findViewById(R.id.button_main_true);
        textViewQuestion = findViewById(R.id.textView_main_question);
    }


}

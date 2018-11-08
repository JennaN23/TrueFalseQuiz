package com.example.truefalsequiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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
    public static final String TAG = "MainActivity";
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        wireWidgets();
        setListeners();
        InputStream stream = getResources().openRawResource(R.raw.questions);
        String jsonString = readTextFile(stream);
        initializeQuiz();


        // create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
// convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
// verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());









    }

    private void setListeners() {
        buttonTrue.setOnClickListener(this);
        buttonFalse.setOnClickListener(this);
    }

    private void initializeQuiz() {
    }

        displayQuestions();

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

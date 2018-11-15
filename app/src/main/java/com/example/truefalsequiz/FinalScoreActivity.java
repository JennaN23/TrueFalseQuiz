package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity{
    private TextView textViewFinalScore;
    private Button buttonPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        wireWidgets();

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPlayAgain = new Intent(FinalScoreActivity.this, MainActivity.class);
                startActivity(intentPlayAgain);
            }
        });
    }

    private void wireWidgets() {
        textViewFinalScore = findViewById(R.id.textView_finalScoreActivity_finalScore);
        String finalScore = getIntent().getStringExtra(MainActivity.FINAL_SCORE);
        textViewFinalScore.setText(finalScore);
        buttonPlayAgain = findViewById(R.id.button_finalScoreActivity_playAgain);
    }
}

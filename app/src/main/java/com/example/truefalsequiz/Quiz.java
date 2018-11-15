package com.example.truefalsequiz;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Quiz {
    private int score = 0;
    private int currentQuestion = 0;
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.score = score;
        this.currentQuestion = currentQuestion;
        this.questions = questions;

    }



    public int getScore(){
        return score;
    }

    public void incrementScore(){
        score++;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Question nextQuestion() {
        Question nextQ = questions.get(currentQuestion);
        currentQuestion++;
        return nextQ;

    }

    public boolean isAnotherQuestion(){
        if(currentQuestion < questions.size()){
            return true;
        }
        else
        {
            return false;
        }
    }



}

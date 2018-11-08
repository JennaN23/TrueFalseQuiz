package com.example.truefalsequiz;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Quiz {
    private int score = 0;
    private int currentQuestion = 0;
    private List<Question> questions;
    private Quiz quiz;
    private Button buttonTrue;
    private Button buttonFalse;

    public Quiz(int score, int currentQuestion, List<Question> questions, Quiz quiz, Button buttonTrue, Button buttonFalse) {
        this.score = score;
        this.currentQuestion = currentQuestion;
        this.questions = questions;
        this.quiz = quiz;
        this.buttonTrue = buttonTrue;
        this.buttonFalse = buttonFalse;
    }

    public int getScore() {
    }
        return score;
    }

    public boolean checkAnswer(){
    if(questions)
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
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

    public void nextQuestion() {
        if(isAnotherQuestion() == true){
            currentQuestion++;
        }
    }

    public boolean isAnotherQuestion(){
        if(currentQuestion < questions.size() - 1){
            return true;
        }
        else
        {
            return false;
        }
    }

    public Question displayQuestions() {
        if(quiz.isAnotherQuestion()){
            Question question = quiz.nextQuestion();
            TextView question.setText(question.getQuestion());
        }
        else{
            quiz.displayScore();
        }



    public void displayScore(){
        getScore();
    }


}

package com.example.truefalsequiz;

import java.util.List;

public class Quiz {
    private int score;
    private int currentQuestion;
    private List<Question> questions;

    public int getScore() {
        return score;
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


}

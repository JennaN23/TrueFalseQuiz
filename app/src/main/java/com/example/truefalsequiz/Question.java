package com.example.truefalsequiz;

public class Question {
    private String question;
    private boolean answer;

    public boolean checkAnswer(boolean userAnswer)
    {
        if(answer != userAnswer){
            return false;
        }
        else{
        return true;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}

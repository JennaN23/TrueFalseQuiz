package com.example.truefalsequiz;

public class Question {
    private String question;
    private boolean answer;

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }

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

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}

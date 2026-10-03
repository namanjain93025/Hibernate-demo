package com.LaunchAssociationOneToMany;

import com.LaunchAssociationOneToOne.Question;
import jakarta.persistence.*;
@Entity
public class AnswerTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answer;
    @ManyToOne(cascade = CascadeType.ALL)
    private QuestionTable question;
    public AnswerTable(){
        System.out.println("This is Answer class constructor");
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionTable getQuestion() {
        return question;
    }

    public void setQuestion(QuestionTable question) {
        this.question = question;
    }
}

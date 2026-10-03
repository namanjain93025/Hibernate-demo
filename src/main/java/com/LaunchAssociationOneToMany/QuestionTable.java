package com.LaunchAssociationOneToMany;

import com.LaunchAssociationOneToOne.Answer;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class QuestionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    private  String question;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AnswerTable> answers;
    public  QuestionTable(){
        System.out.println("This is Question class constructor called ");
    }


    public List<AnswerTable> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerTable> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}

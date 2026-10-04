package com.LaunchHQl;

import jakarta.persistence.*;

@Entity
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
private String name;
private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}

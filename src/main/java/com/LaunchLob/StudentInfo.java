package com.LaunchLob;

import jakarta.persistence.*;

@Entity
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    private String name;
    private  String city;
    @Lob
    private byte[] image;
    @Lob
    private  char[] textFile;

    public char[] getTextFile() {
        return textFile;
    }

    public void setTextFile(char[] textFile) {
        this.textFile = textFile;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

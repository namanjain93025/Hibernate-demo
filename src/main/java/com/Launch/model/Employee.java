package com.Launch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee {
    @Id
    private  Integer eid;

    private  String eName;
    @Transient  //this prevent it to store in db
    private  String eCity;
    private  Integer eage;


    public Integer getEid() {
        return eid;
    }

    public String geteCity() {
        return eCity;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public void seteCity(String eCity) {
        this.eCity = eCity;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}

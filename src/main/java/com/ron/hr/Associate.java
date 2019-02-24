package com.ron.hr;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Associate {

    private @Id @GeneratedValue Long id;
    private  String name;
    public Associate(){}
    public Associate(String name) {
        this.name = name;
    }


}
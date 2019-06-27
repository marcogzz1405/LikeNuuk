package com.example.myapplication.models;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PersonModel {

    private String name;
    private int body;
    private int paisajes;

    public PersonModel(String name, int body, int paisajes) {
        this.name = name;
        this.body = body;
        this.paisajes = paisajes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getPaisajes() {
        return paisajes;
    }

    public void setPaisajes(int paisajes) {
        this.paisajes = paisajes;
    }
}

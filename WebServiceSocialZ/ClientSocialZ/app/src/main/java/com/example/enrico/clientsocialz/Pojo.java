package com.example.enrico.clientsocialz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Enrico on 08/05/2018.
 */

public class Pojo {
    @SerializedName("hobbies")
    @Expose
    private List<Hobby> hobbies=null;

    public List<Hobby> getHobbies(){
        return hobbies;
    }

    public void setHobbies(List<Hobby>hobbies){
        this.hobbies=hobbies;
    }
}

class Hobby{
    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("praticanti")
    @Expose
    private List<String> praticanti=null;

    public String getNome(){
        return nome;

    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public List<String> getPraticanti(){
        return praticanti;
    }

    public void setPraticanti(List<String>praticanti){
        this.praticanti=praticanti;
    }
}

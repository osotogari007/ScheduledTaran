package com.DTO;

/**
 * Created by User on 7/26/2017.
 */


public class PamantDTO implements java.io.Serializable{

    private Integer id;

    private Integer latime;

    private Integer lungime;


    public Integer getId(){
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLatime() {
        return latime;
    }

    public void setLatime(Integer latime) {
        this.latime = latime;
    }

    public Integer getLungime() {
        return lungime;
    }

    public void setLungime(Integer lungime) {
        this.lungime = lungime;
    }




}
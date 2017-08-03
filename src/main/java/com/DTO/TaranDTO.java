package com.DTO;

/**
 * Created by User on 7/26/2017.
 */
import com.DAO.Gen;
import com.DAO.Taran;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TaranDTO implements java.io.Serializable {


    private Long id;

    private String nume;

    private Date dataNastere;

    private Gen gen;

    private Set<PamantDTO> pamanturiDTO = new HashSet<PamantDTO>(0);


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public Set<PamantDTO> getPamanturiDTO(){
        return this.pamanturiDTO;
    }

    public void setPamanturiDTO(Set<PamantDTO> pamanturiDTO){
        this.pamanturiDTO=pamanturiDTO;
    }




}
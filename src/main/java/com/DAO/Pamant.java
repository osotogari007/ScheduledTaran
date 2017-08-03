package com.DAO;

/**
 * Created by User on 7/26/2017.
 */
import com.DTO.PamantDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="pamanturi",catalog = "ioni")
public class Pamant implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_pamant",unique = true,nullable = false)
    private Integer id_pamant;

    @Column(name="latime", precision = 6)
    private Integer latime;

    @Column(name="lungime",precision = 6)
    private Integer lungime;



public PamantDTO toDto(Pamant pamant)
    {
        PamantDTO pamantDTO=new PamantDTO();
        pamantDTO.setId(pamant.getId());
        pamantDTO.setLatime(pamant.getLatime());
        pamantDTO.setLungime(pamant.getLungime());

        return pamantDTO;
    }

public static Pamant fromDto(PamantDTO pamantDTO){
    Pamant pamant = new Pamant();

    pamant.setId(pamantDTO.getId());
    pamant.setLatime(pamantDTO.getLatime());
    pamant.setLungime(pamantDTO.getLungime());
    return pamant;

}

    public Integer getId(){
        return this.id_pamant;
    }


    public void setId(Integer id) {
        this.id_pamant = id;
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

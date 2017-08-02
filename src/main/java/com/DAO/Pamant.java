package com.DAO;

/**
 * Created by User on 7/26/2017.
 */
import com.DTO.PamantDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="pamanturi",catalog = "ioni")
public class Pamant implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private Integer id;

    @Column(name="latime", precision = 6)
    private Integer latime;

    @Column(name="lungime",precision = 6)
    private Integer lungime;


  //  private Taran id_taran;

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
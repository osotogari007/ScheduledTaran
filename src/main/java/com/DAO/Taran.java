package com.DAO;

/**
 * Created by User on 7/26/2017.
 */
import com.DTO.TaranDTO;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity // This tells Hibernate to make a table out of this class
@Table(name="tarani",catalog="ioni")

public class Taran implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;

    @Size(min=1,max = 45)
    @Column(name= "nume", nullable = false, length = 45)
    private String nume;

    @Temporal(TemporalType.DATE)
    @Column(name="dataNastere", nullable = false)
    private Date dataNastere;

    @Column(name="gen",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gen gen;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<Pamant> pamanturi = new HashSet<Pamant>();

    public static Taran fromDTO(TaranDTO taranDto){
        Taran taran= new Taran();
        taran.setId(taranDto.getId());
        taran.setNume(taranDto.getNume());
        taran.setDataNastere(taranDto.getDataNastere());
        taran.setGen(taranDto.getGen());
        return taran;
    }

    public TaranDTO toDTO() {
        TaranDTO taranDTO = new TaranDTO();
        taranDTO.setId(getId());
        taranDTO.setNume(getNume());
        taranDTO.setDataNastere(getDataNastere());
        taranDTO.setGen(getGen());
        return taranDTO;
    }


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
        try {this.gen = gen;}
        catch (EnumConstantNotPresentException e)
        {e.printStackTrace(); }
    }

//    public Set<Pamant> getPamanturi(){
//        return this.pamanturi;
//    }
//
//    public void setPamanturi(Set<Pamant> pamanturi){
//        this.pamanturi =pamanturi;
//    }

    public void addPamant(Pamant pamant) {
        this.pamanturi.add(pamant);



    }



}
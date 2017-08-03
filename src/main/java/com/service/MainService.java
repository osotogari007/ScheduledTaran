package com.service;

import com.DAO.*;
import com.DTO.PamantDTO;

import com.DTO.TaranDTO;

import com.Exception.AgeException;
import com.Exception.AreaException;
import com.Exception.GenException;
import com.Exception.NullTaranIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by User on 7/31/2017.
 */


@Service
public class MainService {

    @Autowired
    public TaranRepository taranRepository;

    @Autowired
    public PamantRepository pamantRepository;

    public  void addNewTaran (TaranDTO taran) throws GenException,AgeException {


        if(!isGenValid(taran.getGen())) {
            throw new GenException();
        }

        if(!isAgeValid(taran.getDataNastere())) {
            throw new AgeException();
        }
        taranRepository.save(Taran.fromDTO(taran));
    }

    public  void addNewPamant (PamantDTO pamantDto, Long taranId) throws NullTaranIdException,AreaException {
    if(!isPamantValid(pamantDto))
        throw new AreaException();

        Taran taran = taranRepository.findOne(taranId);

        if(taran==null)
            throw new NullTaranIdException();

            taran.addPamant(Pamant.fromDto(pamantDto));

            taranRepository.save(taran);

    }

    public  Iterable<Taran> getAllTarani() {
        return taranRepository.findAll();
    }






    private boolean isPamantValid(PamantDTO pamant){
        if(pamant.getLungime()*pamant.getLatime()>100)
            return true;
        return false;
    }

    private boolean isGenValid(Gen gen){
        String genString=gen.name();

        if(genString.equalsIgnoreCase("M"))
            return true;
        return false;
    }

    private boolean isAgeValid(Date date){
        LocalDate localDateOfBirth=dateToLocalDate(date);
        if (localDateOfBirth.isAfter(LocalDate.now().minusYears(18)))
            return false;
        return true;
    }

    private LocalDate dateToLocalDate(Date date){
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }



}
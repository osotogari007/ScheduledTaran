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

    public  void addNewTaran (TaranDTO taran) throws Exception{


        if(!isGenValid(taran.getGen())) {
            throw new GenException();
        }

        if(!isAgeValid(taran.getDataNastere())) {
            throw new AgeException();
        }
        taranRepository.save(Taran.fromDTO(taran));
    }

    public  void addNewPamant (PamantDTO pamantDto, Long taranId) throws Exception{
    if(!isPamantValid(pamantDto))
        throw new AreaException();
        Taran taran =new Taran();
        taran = taranRepository.findOne(taranId);
try {
    taran.addPamant(Pamant.fromDto(pamantDto));
}catch (NullPointerException e){
    throw new NullTaranIdException();
}
  //  taran.addPamant(Pamant.fromDto(pamantDto));
    taranRepository.save(taran);
        pamantRepository.save(Pamant.fromDto(pamantDto));


    }

    public void addTaran(TaranDTO taran) throws Exception {
      //  PamantDTO pamant=new PamantDTO();


        for (PamantDTO pamantInput:taran.getPamanturiDTO()) {
            if(!isPamantValid(pamantInput)) {
                throw new AreaException();
            }
            pamantRepository.save(Pamant.fromDto(pamantInput));

        }

        if(!isGenValid(taran.getGen())) {
            throw new GenException();
        }

        if(!isAgeValid(taran.getDataNastere())) {
            throw new AgeException();
        }

        taranRepository.save(Taran.fromDTO(taran));
    }








//    public @ResponseBody
//    Collection<Pamant> pamanturiDaoToArrayList(){
//
//        Collection<Pamant> arrayListOfPamanturi= new ArrayList<Pamant>();
//
//
//        arrayListOfPamanturi=makeCollection(pamanturiDAORepository.findAll());
//
//        return arrayListOfPamanturi;
//    }
//
//
//
//    public static  Collection<Pamant> makeCollection(Iterable<Pamant> iter) {
//        Collection<Pamant> list = new ArrayList<Pamant>();
//        for (Pamant item : iter) {
//            list.add(item);
//        }
//        return list;
//    }
//
//
//
//    public @ResponseBody
//    Collection<Taran> taraniDaoToArrayList(){
//        Collection<Taran> arrayListOfTarani= new ArrayList<Taran>();
//        arrayListOfTarani=makeCollection2(taraniDAORepository.findAll());
////        for (Taran tdo:         arrayListOfTarani)
////            System.out.println(tdo.getId()+" "+tdo.getNume()+" "+tdo.getDataNastere()+" "+tdo.getGen());
//
//        return arrayListOfTarani;
//
//    }
//
//
//
////    public static  Collection<Taran> makeCollection2(Iterable<Taran> iter) {
////        Collection<Taran> list = new ArrayList<Taran>();
////        for (Taran item : iter) {
////            list.add(item);
////        }
////        return list;
////    }
//
//
//
//    public @ResponseBody Iterable<Pamant> getAllPamanturi() {
//        // This returns a JSON or XML with the users
//
//        return pamanturiDAORepository.findAll();
//    }
//
//
//
//    public @ResponseBody Iterable<Taran> getAllTarani() {
//        // This returns a JSON or XML with the users
//
//        return taraniDAORepository.findAll();
//    }






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
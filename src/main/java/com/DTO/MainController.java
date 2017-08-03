package com.DTO;

import com.DAO.*;

import com.Exception.AgeException;
import com.Exception.GenException;
import com.Exception.AreaException;
import com.Exception.NullTaranIdException;
import com.service.Cronometer;
import com.service.MainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * Created by User on 7/26/2017.
 */



@Controller
@RequestMapping(path="/main")
public class MainController {

    @Autowired
    private MainService mainService;
    @Autowired
    private TaranRepository taranRepository;
    @Autowired
    private PamantRepository pamantRepository;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    private Cronometer cronometer=new Cronometer();

    @RequestMapping(path="/addTaran",method = RequestMethod.POST)
    @ResponseBody
    public String addNewTaran(@RequestBody TaranDTO taran){

        cronometer.startTimer();

        try {
            mainService.addNewTaran(taran);
        } catch (AgeException | GenException  | javax.validation.ConstraintViolationException validationException) {
               return validationException.getMessage();
        }

        cronometer.stopTimer();
        log.info("Execution took {} miliseconds! ",cronometer.time());

        return "Taran adaugat.";
    }



    @RequestMapping(path="/addPamant",method = RequestMethod.POST)
    @ResponseBody
    public String addNewPamant(@RequestBody PamantDTO pamant,@RequestParam(value = "id") Long id){
        cronometer.startTimer();
        try {
            mainService.addNewPamant(pamant,id);
        } catch (AreaException | NullTaranIdException  exception) {
            return exception.getMessage();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        cronometer.stopTimer();
        log.info("Execution took {} miliseconds! ",cronometer.time());

        return "Pamant adaugat!";
    }

    @RequestMapping(path="/lstTaran",method = RequestMethod.GET)
    public @ResponseBody Iterable<Taran> getAllTarani() {
        return getAllTarani();

    }

}

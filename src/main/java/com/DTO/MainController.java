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
    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    private Cronometer cronometer=new Cronometer();
    //private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

//    @RequestMapping(path="/add",method = RequestMethod.POST)
//    @ResponseBody
//    public String addTarani( @RequestBody TaranDTO input){
//
//        try {
//            mainService.addTaran(input);
//        } catch (AgeException | GenException | AreaException validationException) {
//          return validationException.getMessage();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    return "ok";
//    }

    @RequestMapping(path="/addTaran",method = RequestMethod.POST)
    @ResponseBody
    public String addNewTaran(@RequestBody TaranDTO taran){

        cronometer.startTimer();


        try {
            mainService.addNewTaran(taran);
        } catch (AgeException | GenException  | javax.validation.ConstraintViolationException validationException) {
               return validationException.getMessage();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        cronometer.stopTimer();
        log.info("Execution took {} miliseconds! ",cronometer.time());

        return "ok";


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
        return "ok";
    }





//
//    @Autowired
//  private MainServiceDTO mainServiceDTO;
//
//
//    @RequestMapping(path = "/dtoLstPamanturi")
//    public @ResponseBody Collection<PamantDTO> pamanturiDtoToArrayList() {
//
//        return mainServiceDTO.pamanturiDtoToArrayList();
//    }
//
//    @RequestMapping(path = "/dtoLstTarani")
//    public @ResponseBody Collection<TaranDTO> taraniDtoToArrayList() {
//        Collection<TaranDTO> arrayListOfTarani = new ArrayList<TaranDTO>();
//
//        return mainServiceDTO.taraniDtoToArrayList();
//    }
//
//    @GetMapping(path = "/dtoAllPamanturi")
//    public @ResponseBody Iterable<PamantDTO> getAllPamanturiDto() {
//        // This returns a JSON or XML with the users
//
//        return mainServiceDTO.getAllPamanturi();
//    }
//
//    @GetMapping(path = "/dtoAllTarani")
//    public @ResponseBody Iterable<TaranDTO> getAllTaraniDto() {
//        // This returns a JSON or XML with the users
//
//        return mainServiceDTO.getAllTarani();
//    }





//
//    @Autowired
//   private MainServiceCevadinDAO mainServiceDAO;
//
//    @RequestMapping(path="/daoLstPamanturi")
//    public @ResponseBody Collection<Pamant> returnAnArraylistOfPamanturiDao(){
//
//        return mainServiceDAO.pamanturiDaoToArrayList();
//    }
//
//    @RequestMapping(path="/daoLstTarani")
//    public @ResponseBody Collection<Taran> returnAnArraylistOfaraniDao(){
//
//        return mainServiceDAO.taraniDaoToArrayList();
//
//    }
//
//    @GetMapping(path="/daoAllPamanturi")
//    public @ResponseBody Iterable<Pamant> getAllPamanturiDao() {
//
//        return mainServiceDAO.getAllPamanturi();
//    }
//
//    @GetMapping(path="/daoAllTarani")
//    public @ResponseBody Iterable<Taran> getAllTaraniDao() {
//
//
//        return mainServiceDAO.getAllTarani();
//    }


















}

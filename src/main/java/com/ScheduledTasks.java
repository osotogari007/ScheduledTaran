//package com;
//
///**
// * Created by User on 7/28/2017.
// */
//
//import java.text.SimpleDateFormat;
//
//
//import com.DTO.MainController;
//import org.slf4j.Logger;
//        import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//
//public class ScheduledTasks {
//
//    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    int i=1;
//    @Autowired
//    MainController mC;
//
//
//
//  // @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//
//       long startTime = System.currentTimeMillis();
//
//        mC.updateCheck();
//
//
//      long endTime = System.currentTimeMillis();
//
//
//        log.info("Execution took {} miliseconds! ", endTime-startTime);
//
//
//
//
//        System.out.println("Check number "+i+" done!");
//        i++;
//    }
//}
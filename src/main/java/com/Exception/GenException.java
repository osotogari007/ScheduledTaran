package com.Exception;

/**
 * Created by User on 8/1/2017.
 */
public class GenException extends Exception{

    public GenException(){

        super("Doar taranii de gen M sunt acceptati");
    }

    public GenException (String message){
        super(message);
    }

}

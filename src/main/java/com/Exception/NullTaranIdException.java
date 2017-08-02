package com.Exception;

/**
 * Created by User on 8/2/2017.
 */
public class NullTaranIdException extends Exception {
    public NullTaranIdException() {
        super("Nu exista un taran cu acest id");
    }
}

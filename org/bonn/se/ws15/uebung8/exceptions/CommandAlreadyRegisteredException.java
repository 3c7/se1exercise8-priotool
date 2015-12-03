package org.bonn.se.ws15.uebung8.exceptions;

/**
 * Created by Nils on 03.12.2015.
 */
public class CommandAlreadyRegisteredException extends Exception {
    private String cmdName;

    public CommandAlreadyRegisteredException(String name) {
        cmdName = name;
    }

    public String getCmdName() {
        return cmdName;
    }
}

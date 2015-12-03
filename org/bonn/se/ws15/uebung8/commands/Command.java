package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.exceptions.*;

/**
 * Created by Nils on 03.12.2015.
 */
public interface Command {
    void execute(String[] args) throws ContainerFullException, UserQuitException, ParametersMissingException, ValuesOutOfRangeException, NotAFibonacciNumberException;
    String getName();
}

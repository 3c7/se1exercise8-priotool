package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.exceptions.UserQuitException;

/**
 * Created by Nils on 03.12.2015.
 */
public class QuitCommand implements Command  {
    private final String NAME = "quit";

    public void execute(String[] args) throws UserQuitException {
        throw new UserQuitException();
    }

    public String getName() {
        return NAME;
    }
}

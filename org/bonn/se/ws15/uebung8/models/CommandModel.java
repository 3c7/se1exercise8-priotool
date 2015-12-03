package org.bonn.se.ws15.uebung8.models;

import org.bonn.se.ws15.uebung8.commands.Command;
import org.bonn.se.ws15.uebung8.exceptions.CommandAlreadyRegisteredException;

import java.util.HashMap;

/**
 * Created by Nils on 03.12.2015.
 */
public class CommandModel {
    private static CommandModel instance = null;
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    private CommandModel(){}

    public void addCommand(Command c) throws CommandAlreadyRegisteredException {
        if (commands.containsKey(c.getName()))
            throw new CommandAlreadyRegisteredException(c.getName());

        commands.put(c.getName(), c);
    }

    public void removeCommand(String key) {
        if (commands.containsKey(key))
            commands.remove(key);
    }

    public boolean containsCommand(String key) {
        return commands.containsKey(key);
    }

    public synchronized static CommandModel getInstance() {
        if (instance != null) return instance;
        return instance = new CommandModel();
    }
}

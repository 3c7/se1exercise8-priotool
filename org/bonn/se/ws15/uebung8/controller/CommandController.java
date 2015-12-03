package org.bonn.se.ws15.uebung8.controller;

import org.bonn.se.ws15.uebung8.commands.*;
import org.bonn.se.ws15.uebung8.models.CommandModel;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

import java.util.HashMap;

/**
 * COMMANDCONTROLLER
 * Created by Nils on 03.12.2015.
 */
public class CommandController {
    private CommandModel commandModel = CommandModel.getInstance();
    private ConsoleView conView = new ConsoleView();

    public CommandController() {
        this.commandModel.addCommand(new EnterCommand());
        this.commandModel.addCommand(new HelpCommand());
        this.commandModel.addCommand(new QuitCommand());
        this.commandModel.addCommand(new DumpCommand());
    }
}

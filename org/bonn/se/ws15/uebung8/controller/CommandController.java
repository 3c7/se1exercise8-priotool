package org.bonn.se.ws15.uebung8.controller;

import org.bonn.se.ws15.uebung8.commands.EnterCommand;
import org.bonn.se.ws15.uebung8.commands.HelpCommand;
import org.bonn.se.ws15.uebung8.exceptions.CommandAlreadyRegisteredException;
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
        try {
            this.commandModel.addCommand(new EnterCommand());
            this.commandModel.addCommand(new HelpCommand());
        } catch (CommandAlreadyRegisteredException care) {
            conView.out("Command " + care.getCmdName() + " bereits vorhanden.");
        }
    }
}

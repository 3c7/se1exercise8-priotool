package org.bonn.se.ws15.uebung8.controller;

import org.bonn.se.ws15.uebung8.commands.*;
import org.bonn.se.ws15.uebung8.models.CommandModel;

/**
 * COMMANDCONTROLLER
 * Created by Nils on 03.12.2015.
 */
class CommandController {

    public CommandController() {
        CommandModel commandModel = CommandModel.getInstance();
        commandModel.addCommand(new EnterCommand());
        commandModel.addCommand(new HelpCommand());
        commandModel.addCommand(new QuitCommand());
        commandModel.addCommand(new DumpCommand());
        commandModel.addCommand(new StoreCommand());
        commandModel.addCommand(new LoadCommand());
    }
}

package org.bonn.se.ws15.uebung8.controller;

import org.bonn.se.ws15.uebung8.commands.Command;
import org.bonn.se.ws15.uebung8.dtos.UserInputDTO;
import org.bonn.se.ws15.uebung8.exceptions.*;
import org.bonn.se.ws15.uebung8.models.CommandModel;
import org.bonn.se.ws15.uebung8.util.Config;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

import java.io.IOException;

/**
 * Created by Nils on 03.12.2015.
 */
public class ConsoleController {
    private ConsoleView conView = new ConsoleView();
    private CommandModel commandModel = CommandModel.getInstance();


    public void call() {
        UserInputDTO input;
        Command command;
        CommandController commandController = new CommandController();

        conView.outLine("# MVC Priotool");
        while (true) {
            try {
                input = conView.readLine();
                if ((command = commandModel.getCommand(input.getCommand())) == null) {
                    conView.outLine("Ungültiger Befehl.");
                    command = commandModel.getCommand(Config.HELP_COMMAND);
                }
                command.execute(input.getParameters());

            } catch (IOException ioe) {
                conView.outLine("Konnte nicht von Console lesen.");
            } catch (ContainerFullException cfe) {
                conView.outLine("Maximale Anzahl an UserStories wurde eingegeben.");
            } catch (NotAFibonacciNumberException nafne) {
                conView.outLine("Eingegebener Aufwand entspricht nicht den vorgegebenen Fibonacci Zahlen.");
            } catch (ValuesOutOfRangeException voore) {
                conView.outLine("Eingegebene Parameter nicht im Wertebereich (1-5, Aufwand muss Fibonacci Zahl sein.)");
            } catch (ParametersMissingException pme) {
                conView.outLine("Wichtige Parameter fehlen. Hilfe per: 'help'.");
            } catch (UserQuitException uqe) {
                return;
            }
        }
    }
}

package org.bonn.se.ws15.uebung8.controller;

import org.bonn.se.ws15.uebung8.commands.Command;
import org.bonn.se.ws15.uebung8.dtos.UserInputDTO;
import org.bonn.se.ws15.uebung8.exceptions.*;
import org.bonn.se.ws15.uebung8.models.CommandModel;
import org.bonn.se.ws15.uebung8.util.Config;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Nils on 03.12.2015.
 */
public class ConsoleController {
    private final ConsoleView conView = new ConsoleView();
    private final CommandModel commandModel = CommandModel.getInstance();
    private final CommandController commandController = new CommandController();


    public void call() {
        UserInputDTO input;
        Command command;

        conView.outLine("# MVC Priotool");
        while (true) {
            try {
                input = conView.readLine();
                if ((command = commandModel.getCommand(input.getCommand())) == null) {
                    conView.outLine("Ungültiger Befehl.");
                    command = commandModel.getCommand(Config.HELP_COMMAND);
                }
                command.execute(input.getParameters());

            } catch (FileNotFoundException fnfe) {
                conView.outLine("Datei nicht gefunden.");
            } catch (IOException ioe) {
                conView.outLine("Ein-/Ausgabe Fehler.");
            } catch (ContainerFullException cfe) {
                conView.outLine("Maximale Anzahl an UserStories wurde eingegeben.");
            } catch (NotAFibonacciNumberException nafne) {
                conView.outLine("Eingegebener Aufwand entspricht nicht den vorgegebenen Fibonacci Zahlen.");
            } catch (ValuesOutOfRangeException voore) {
                conView.outLine("Eingegebene Parameter nicht im Wertebereich (1-5, Aufwand muss Fibonacci Zahl sein.)");
            } catch (ParametersMissingException pme) {
                conView.outLine("Wichtige Parameter fehlen. Hilfe per: 'help'.");
            } catch (StoreIOException sioe) {
                conView.outLine("Fehler beim Speichern in Datei.");
            } catch (LoadIOException lioe) {
                conView.outLine("Fehler beim Laden aus Datei.");
            } catch (UserQuitException uqe) {
                return;
            }
        }
    }
}

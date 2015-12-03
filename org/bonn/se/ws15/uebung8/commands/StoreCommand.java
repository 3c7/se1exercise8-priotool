package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.exceptions.ParametersMissingException;
import org.bonn.se.ws15.uebung8.exceptions.StoreIOException;
import org.bonn.se.ws15.uebung8.models.UserStoryModel;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Nils on 03.12.2015.
 */
public class StoreCommand implements Command {
    private final String NAME = "store";
    private final UserStoryModel userStoryModel = UserStoryModel.getInstance();
    private final ConsoleView conView = new ConsoleView();
    private ObjectOutputStream outputStream;

    public void execute(String[] args) throws ParametersMissingException, FileNotFoundException, StoreIOException {
        try {
            String filename = args[0];
            outputStream = new ObjectOutputStream(new FileOutputStream(filename + ".priotool", false));
            outputStream.writeObject(userStoryModel.exportUserStories());
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new ParametersMissingException();
        } catch (IOException ioe) {
            throw new StoreIOException();
        } finally {
            try {
                outputStream.close();
            } catch (IOException ioe) {
                conView.outLine("Fehler beim Schließen des Output Streams.");
            }
        }
        conView.outLine("Speicher erfolgreich. (" + args[0] + ".priotool)");
    }

    public String getName() {
        return NAME;
    }
}

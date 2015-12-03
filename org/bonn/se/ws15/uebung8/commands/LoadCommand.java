package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.dtos.UserStoryDTO;
import org.bonn.se.ws15.uebung8.exceptions.LoadIOException;
import org.bonn.se.ws15.uebung8.exceptions.ParametersMissingException;
import org.bonn.se.ws15.uebung8.models.UserStoryModel;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Nils on 03.12.2015.
 */

public class LoadCommand implements Command {
    private final String NAME = "load";
    private final UserStoryModel userStoryModel = UserStoryModel.getInstance();
    private final ConsoleView conView = new ConsoleView();
    private ObjectInputStream inputStream;

    public void execute(String[] args) throws ParametersMissingException, FileNotFoundException, LoadIOException {
        try {
            String filename = args[0];
            inputStream = new ObjectInputStream(new FileInputStream(filename + ".priotool"));
            userStoryModel.importUserStories((List<UserStoryDTO>) inputStream.readObject());
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new ParametersMissingException();
        } catch (IOException ioe) {
            throw new LoadIOException();
        } catch (ClassNotFoundException cnfe) {
            throw new LoadIOException();
        } finally {
            try {
                inputStream.close();
            } catch (IOException ioe) {
                conView.outLine("Fehler beim Schliessen des Input Streams.");
            }
        }
        conView.outLine("Laden erfolgreich. (" + args[0] + ")");
    }

    public String getName() {
        return NAME;
    }
}

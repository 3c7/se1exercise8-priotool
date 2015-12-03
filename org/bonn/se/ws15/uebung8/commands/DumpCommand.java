package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.models.UserStoryModel;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

/**
 * Created by Nils on 03.12.2015.
 */
public class DumpCommand implements Command {
    private final UserStoryModel userStoryModel = UserStoryModel.getInstance();
    private final ConsoleView conView = new ConsoleView();
    private final String NAME = "dump";

    public void execute(String[] args) {
        System.out.println(userStoryModel.dump());
    }

    public String getName() {
        return NAME;
    }
}

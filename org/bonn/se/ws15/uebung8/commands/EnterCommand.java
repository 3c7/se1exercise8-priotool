package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.dtos.UserStoryDTO;
import org.bonn.se.ws15.uebung8.exceptions.ContainerFullException;
import org.bonn.se.ws15.uebung8.exceptions.NotAFibonacciNumberException;
import org.bonn.se.ws15.uebung8.exceptions.ParametersMissingException;
import org.bonn.se.ws15.uebung8.exceptions.ValuesOutOfRangeException;
import org.bonn.se.ws15.uebung8.models.UserStoryModel;
import org.bonn.se.ws15.uebung8.util.Config;
import org.bonn.se.ws15.uebung8.util.Util;
import org.bonn.se.ws15.uebung8.views.ConsoleView;

/**
 * Created by Nils on 03.12.2015.
 */
public class EnterCommand implements Command {
    private final int MAX = Config.MAX;
    private final ConsoleView conView = new ConsoleView();
    private final UserStoryModel userStoryModel = UserStoryModel.getInstance();

    public void execute(String[] args) throws ContainerFullException, ParametersMissingException, ValuesOutOfRangeException, NotAFibonacciNumberException {
        if (userStoryModel.getCount() == MAX) throw new ContainerFullException();

        try {
            int value = Integer.parseInt(args[1]);
            int effort = Integer.parseInt(args[2]);
            int risk = Integer.parseInt(args[3]);
            int penalty = Integer.parseInt(args[4]);
            double priority = Util.calcPriority(value, effort, risk, penalty);

            if (!Util.checkRange(value, risk, penalty))
                throw new ValuesOutOfRangeException();

            if (!Util.isFibonnaci(effort))
                throw new NotAFibonacciNumberException();

            UserStoryDTO uStory = new UserStoryDTO(args[0], value, effort, risk, penalty, priority);
            userStoryModel.addStory(uStory);

            conView.outLine("User Story " + uStory.getTitle() + " wurde erfolgreich hinzugefügt.");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new ParametersMissingException();
        }

    }

    public String getName() {
        return "enter";
    }
}

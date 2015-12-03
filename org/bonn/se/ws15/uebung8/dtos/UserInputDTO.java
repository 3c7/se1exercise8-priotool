package org.bonn.se.ws15.uebung8.dtos;

/**
 * Created by Nils on 03.12.2015.
 */
public class UserInputDTO {
    private String command;
    private String[] parameters;

    public UserInputDTO(String s) {
        if (s.contains(" ")) {
            command = s.substring(0, s.indexOf(" "));
            parameters = s.substring(s.indexOf(" ") + 1).split(",");
        } else {
            command = s;
        }
    }

    public String getCommand() {
        return command;
    }

    public String[] getParameters() {
        return parameters;
    }
}

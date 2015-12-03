package org.bonn.se.ws15.uebung8.views;

import org.bonn.se.ws15.uebung8.dtos.UserInputDTO;

import java.io.IOException;

/**
 * Created by Nils on 03.12.2015.
 */
interface View {
    void out(String s);
    void outLine(String s);
    UserInputDTO readLine() throws IOException;
}

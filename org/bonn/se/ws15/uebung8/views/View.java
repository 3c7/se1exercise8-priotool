package org.bonn.se.ws15.uebung8.views;

import java.io.IOException;

/**
 * Created by Nils on 03.12.2015.
 */
public interface View {
    void out(String s);
    void outLine(String s);
    String readLine() throws IOException;
}

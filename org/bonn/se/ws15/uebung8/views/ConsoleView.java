package org.bonn.se.ws15.uebung8.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nils on 03.12.2015.
 */
public class ConsoleView implements View {
    private BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

    public void outLine(String s) {
        System.out.println(s);
    }

    public void out(String s) {
        System.out.print(s);
    }

    public String readLine() throws IOException {
        // Cursor
        this.out("> ");

        // Read
        return bReader.readLine();
    }


}

package org.bonn.se.ws15.uebung8.controller;

import org.bonn.se.ws15.uebung8.views.ConsoleView;

/**
 * Created by Nils on 03.12.2015.
 */
public class ConsoleController {
    private ConsoleView conView = new ConsoleView();


    public void call() {
        conView.outLine("# MVC Priotool");
    }
}

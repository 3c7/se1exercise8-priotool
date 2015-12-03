package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.views.View;

/**
 * Created by Nils on 03.12.2015.
 */
public abstract class Command {
    public abstract void execute();
    public abstract String getName();
}

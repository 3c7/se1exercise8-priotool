package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.views.ConsoleView;

/**
 * Created by Nils on 03.12.2015.
 */
public class HelpCommand implements Command {
    private final ConsoleView conView = new ConsoleView();

    public void execute(String[] args) {
        conView.outLine("Hilfe:\n>_ Befehl [parameter]\n" +
                "Mögliche Befehle:\n" +
                "enter titel,V,A,R,S\t-\tEine neue Userstory eingeben; V->Value, R->Risiko, S->Strafe als Ganzzahlen [1-5]; A->Aufwand als Fibonacci Zahl\n" +
                "load file\t\t\t-\tUserstories mit dem Dateinamen file laden\n" +
                "store file\t\t\t-\tUserstories mit dem Dateinamen file speichern\n" +
                "help\t\t\t\t-\tZeigt diese Hilfe an\n" +
                "quit				-	Beendet das Programm");
    }

    public String getName() {
        return "help";
    }
}

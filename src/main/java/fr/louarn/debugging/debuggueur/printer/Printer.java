package fr.louarn.debugging.debuggueur.printer;

import fr.louarn.debugging.debuggueur.programTrace.IProgramTrace;
import fr.louarn.debugging.debuggueur.trace.ITrace;
import fr.louarn.debugging.debuggueur.trace.Level;
import fr.louarn.debugging.debuggueur.trace.Value;
import fr.louarn.debugging.debuggueur.utils.Constants;

import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class Printer implements IDebuggerVisitor {

    /**
     * Attributes
     */
    private PrintStream out;

    private Level level;

    /**
     * Constructeur
     */
    public Printer(PrintStream out, Level level) {
        this.out = out;
        this.level = level;
    }

    /**
     * Méthodes de l'interface IDebuggerVisitor
     */

    @Override
    public void visite(IProgramTrace programTrace) {
        programTrace.forEach(trace -> trace.accept(this));
    }

    @Override
    public void visite(ITrace trace) {
        if (this.level.getLevel() <= trace.getLevel().getLevel()) {
            this.out.print("[ date: ");

            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_PATTERN);
            this.out.print(sdf.format(trace.getCalendar().getTime()));

            this.out.print(", level: ");
            trace.getLevel().accept(this);

            this.out.print(", origine: ");
            this.out.print(trace.getOrigine());

            if (trace.getValue() != null) {
                this.out.print(", value: ");
                trace.getValue().accept(this);
            }

            this.out.println("]");

        }
    }

    @Override
    public void visite(Level level) {
        this.out.print(level.getLevel());
    }

    @Override
    public void visite(Value value) {
        this.out.print(value.getValue());
    }
}

package fr.louarn.debugging.printer;

import fr.louarn.debugging.program.trace.IProgramTrace;
import fr.louarn.debugging.trace.ITrace;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Value;
import fr.louarn.debugging.utils.Constants;

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
        if (this.level.getValue() <= trace.getLevel().getValue()) {

            StackTraceElement l = trace.getStackTraceElement();
            this.out.print(l.getClassName()
                    + "/"
                    + l.getMethodName()
                    + ":"
                    + l.getLineNumber()
                    + " ---> "
            );

            this.out.print("[ date: ");

            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_PATTERN);
            this.out.print(sdf.format(trace.getCalendar().getTime()));

            this.out.print(", level: ");
            trace.getLevel().accept(this);

            if (trace.getName() != null) {
                this.out.print(", name : "+trace.getName());
            }

            if (trace.getValue() != null) {
                this.out.print(", value: ");
                trace.getValue().accept(this);
            }

            this.out.println("]");



//            StackTraceElement l = new Exception().getStackTrace()[0];
//            System.out.println(l.getClassName() + "/" + l.getMethodName() + ":" + l.getLineNumber());
        }
    }

    @Override
    public void visite(Level level) {
        this.out.print(level.getValue());
    }

    @Override
    public void visite(Value value) {
        this.out.print(value.getValue());
    }
}

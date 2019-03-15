package fr.louarn.debugging.trace;

import fr.louarn.debugging.printer.IDebuggerVisitor;

import java.util.Calendar;

public class Trace implements ITrace {

    /**
     * Attributs
     */
    private static final long serialVersionUID = 3L;

    private Calendar calendar;

    private Level level;


    private String name;

    private Value value;

    private StackTraceElement stackTraceElement;

    /**
     * Constructeurs
     */
    public Trace() {
        super();
    }

    public Trace(Calendar calendar, Level level, String name, Value value, StackTraceElement stackTraceElement) {
        this.calendar = calendar;
        this.level = level;
        this.name = name;
        this.value = value;
        this.stackTraceElement = stackTraceElement;
    }

    public Trace(Calendar calendar, Level level, StackTraceElement stackTraceElement) {
        this.calendar = calendar;
        this.level = level;
        this.stackTraceElement = stackTraceElement;

    }

    /**
     * Méthodes de l'inerface ITrace
     */

    @Override
    public void save(Value value) {
        this.value = value;
    }

    /**
     * Methodes de l'inerface IDebuggerVisitable
     */

    @Override
    public void accept(IDebuggerVisitor visitor) {
        visitor.visite(this);
    }

    /**
     * Acccesseurs
     */
    @Override
    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public void setValue(Value value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StackTraceElement getStackTraceElement() {
        return stackTraceElement;
    }

    public void setStackTraceElement(StackTraceElement stackTraceElement) {
        this.stackTraceElement = stackTraceElement;
    }
}

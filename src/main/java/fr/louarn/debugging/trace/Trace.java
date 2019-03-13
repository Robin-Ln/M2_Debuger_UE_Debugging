package fr.louarn.debugging.trace;

import fr.louarn.debugging.printer.IDebuggerVisitor;

import java.io.Serializable;
import java.util.Calendar;

public class Trace implements ITrace {

    /**
     * Attributs
     */
    private static final long serialVersionUID = 3L;

    private Calendar calendar;

    private Level level;

    private String origine;

    private Value value;

    /**
     * Constructeurs
     */
    public Trace() {
        super();
    }

    public Trace(Calendar calendar, Level level, String origine, Value value) {
        this.calendar = calendar;
        this.level = level;
        this.origine = origine;
        this.value = value;
    }

    public Trace(Calendar calendar, Level level, String origine) {
        this.calendar = calendar;
        this.level = level;
        this.origine = origine;
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
    public String getOrigine() {
        return origine;
    }

    @Override
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public void setValue(Value value) {
        this.value = value;
    }
}

package fr.louarn.debugging.trace;

import fr.louarn.debugging.printer.IDebuggerVisitable;

import java.io.Serializable;
import java.util.Calendar;

public interface ITrace extends IDebuggerVisitable, Serializable {

    void save(Value value);

    /**
     * Accesseur
     */

    Calendar getCalendar();

    void setCalendar(Calendar calendar);

    Level getLevel();

    void setLevel(Level level);

    String getOrigine();

    void setOrigine(String origine);

    Value getValue();

    void setValue(Value value);
}

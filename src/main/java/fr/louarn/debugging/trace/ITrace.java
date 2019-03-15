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


    Value getValue();

    void setValue(Value value);

    String getName();

    void setName(String name);

    StackTraceElement getStackTraceElement();

    void setStackTraceElement(StackTraceElement stackTraceElement);
}

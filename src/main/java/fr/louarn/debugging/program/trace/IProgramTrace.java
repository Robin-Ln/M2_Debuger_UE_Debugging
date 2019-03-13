package fr.louarn.debugging.program.trace;

import fr.louarn.debugging.printer.IDebuggerVisitable;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Trace;
import fr.louarn.debugging.trace.Value;

import java.io.Serializable;
import java.util.Calendar;

public interface IProgramTrace extends IDebuggerVisitable, Iterable<Trace>, Serializable {
    Trace next();

    Trace previous();

    Boolean hasNext();

    Boolean hasPrevious();

    void addTrace(Level level, String origine, String value);

    void addTrace(Level level, String origine, Integer value);

    void addTrace(Level level, String origine, Float value);

    void addTrace(Level level, String origine);

    int size();

    Trace get(int i);

    void clear();
}

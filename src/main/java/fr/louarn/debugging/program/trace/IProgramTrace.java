package fr.louarn.debugging.program.trace;

import fr.louarn.debugging.printer.IDebuggerVisitable;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Trace;

import java.io.Serializable;

public interface IProgramTrace extends IDebuggerVisitable, Iterable<Trace>, Serializable {
    Trace next();

    Trace previous();

    Boolean hasNext();

    Boolean hasPrevious();

    void addTrace(Level level, String name, String value, StackTraceElement l);

    void addTrace(Level level, String name, Integer value, StackTraceElement l);

    void addTrace(Level level, String name, Float value, StackTraceElement l);

    void addTrace(Level level, StackTraceElement l);

    int size();

    Trace get(int i);

    void clear();
}

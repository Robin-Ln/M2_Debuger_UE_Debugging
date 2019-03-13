package fr.louarn.debugging.program.trace;

import fr.louarn.debugging.printer.IDebuggerVisitable;
import fr.louarn.debugging.trace.Trace;

public interface IProgramTrace extends IDebuggerVisitable, Iterable<Trace> {

    Trace next();

    Trace previous();

    Boolean hasNext();

    Boolean hasPrevious();

}

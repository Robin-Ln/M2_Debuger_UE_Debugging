package fr.louarn.debugging.debuggueur.program.trace;

import fr.louarn.debugging.debuggueur.printer.IDebuggerVisitable;
import fr.louarn.debugging.debuggueur.trace.Trace;

public interface IProgramTrace extends IDebuggerVisitable, Iterable<Trace> {

    Trace next();

    Trace previous();

    Boolean hasNext();

    Boolean hasPrevious();

}

package debuggueur.programTrace;

import debuggueur.printer.IDebuggerVisitable;
import debuggueur.trace.Trace;

public interface IProgramTrace extends IDebuggerVisitable, Iterable<Trace> {

    Trace next();

    Trace previous();

    Boolean hasNext();

    Boolean hasPrevious();

}

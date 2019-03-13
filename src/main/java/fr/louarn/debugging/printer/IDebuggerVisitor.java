package fr.louarn.debugging.printer;

import fr.louarn.debugging.program.trace.IProgramTrace;
import fr.louarn.debugging.trace.ITrace;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Value;

public interface IDebuggerVisitor {

    void visite(IProgramTrace programTrace);

    void visite(ITrace trace);

    void visite(Level level);

    void visite(Value value);

}

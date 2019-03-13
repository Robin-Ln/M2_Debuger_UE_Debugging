package fr.louarn.debugging.debuggueur.printer;

import fr.louarn.debugging.debuggueur.program.trace.IProgramTrace;
import fr.louarn.debugging.debuggueur.trace.ITrace;
import fr.louarn.debugging.debuggueur.trace.Level;
import fr.louarn.debugging.debuggueur.trace.Value;

public interface IDebuggerVisitor {

    void visite(IProgramTrace programTrace);

    void visite(ITrace trace);

    void visite(Level level);

    void visite(Value value);

}

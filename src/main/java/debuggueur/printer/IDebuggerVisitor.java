package debuggueur.printer;

import debuggueur.programTrace.IProgramTrace;
import debuggueur.trace.ITrace;
import debuggueur.trace.Level;
import debuggueur.trace.Value;

public interface IDebuggerVisitor {

    void visite(IProgramTrace programTrace);

    void visite(ITrace trace);

    void visite(Level level);

    void visite(Value value);

}

package fr.louarn.debugging.debuggueur.printer;

public interface IDebuggerVisitable {
    void accept(IDebuggerVisitor visitor);
}

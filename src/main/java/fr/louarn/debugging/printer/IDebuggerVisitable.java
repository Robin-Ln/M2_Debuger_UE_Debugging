package fr.louarn.debugging.printer;

public interface IDebuggerVisitable {
    void accept(IDebuggerVisitor visitor);
}

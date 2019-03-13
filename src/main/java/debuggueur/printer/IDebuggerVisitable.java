package debuggueur.printer;

public interface IDebuggerVisitable {
    void accept(IDebuggerVisitor visitor);
}

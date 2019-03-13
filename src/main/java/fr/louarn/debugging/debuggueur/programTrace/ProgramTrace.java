package fr.louarn.debugging.debuggueur.programTrace;

import fr.louarn.debugging.debuggueur.printer.IDebuggerVisitor;
import fr.louarn.debugging.debuggueur.trace.Trace;

import java.io.Serializable;
import java.util.LinkedList;

public class ProgramTrace extends LinkedList<Trace> implements IProgramTrace, Serializable {

    /**
     * Attribute
     */
    private Integer index;

    /**
     * Constructeur
     */
    public ProgramTrace() {
        this.index = 0;
    }

    /**
     * Methode de l'inerface IDebuggerVisitable
     */

    @Override
    public void accept(IDebuggerVisitor visitor) {
        visitor.visite(this);
    }

    /**
     * Methode de l'interface IProgramTrace
     */
    @Override
    public Trace next() {
        if (this.hasNext()) {
            return this.get(this.index++);
        }
        throw new RuntimeException("RuntimeException : ProgramTrace next()");
    }

    @Override
    public Trace previous() {
        if (this.hasPrevious()) {
            return this.get(--this.index);
        }
        throw new RuntimeException("RuntimeException : ProgramTrace previous()");
    }

    @Override
    public Boolean hasNext() {
        return this.index < this.size();
    }

    @Override
    public Boolean hasPrevious() {
        return this.index - 1 >= 0;
    }
}

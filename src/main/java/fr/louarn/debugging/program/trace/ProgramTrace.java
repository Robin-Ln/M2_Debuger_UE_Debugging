package fr.louarn.debugging.program.trace;

import fr.louarn.debugging.printer.IDebuggerVisitor;
import fr.louarn.debugging.trace.Trace;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

public class ProgramTrace extends LinkedList<Trace> implements IProgramTrace, Serializable {

    /**
     * Attribute
     */
    private static final long serialVersionUID = 1L;

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
        throw new IndexOutOfBoundsException("fail : ProgramTrace next()");
    }

    @Override
    public Trace previous() {
        if (this.hasPrevious()) {
            return this.get(--this.index);
        }
        throw new IndexOutOfBoundsException("fail : ProgramTrace previous()");
    }


    @Override
    public Boolean hasNext() {
        return this.index < this.size();
    }

    @Override
    public Boolean hasPrevious() {
        return this.index - 1 >= 0;
    }

    /**
     * Autre methodes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProgramTrace traces = (ProgramTrace) o;
        return index.equals(traces.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), index);
    }
}

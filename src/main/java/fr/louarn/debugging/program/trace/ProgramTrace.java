package fr.louarn.debugging.program.trace;

import fr.louarn.debugging.printer.IDebuggerVisitor;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Trace;
import fr.louarn.debugging.trace.Value;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Objects;

public class ProgramTrace extends LinkedList<Trace> implements IProgramTrace {

    /**
     * Attribute
     */
    private static final long serialVersionUID = 1L;

    private static IProgramTrace programTrace;

    private Integer index;

    /**
     * Constructeur
     */
    private ProgramTrace() {
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
    public static IProgramTrace getInstance() {
        if (ProgramTrace.programTrace == null) {
            ProgramTrace.programTrace = new ProgramTrace();
        }
        return ProgramTrace.programTrace;
    }

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
    public void addTrace(Level level, String origine, String value) {
        this.add(new Trace(Calendar.getInstance(), level, origine, new Value(value)));
    }

    @Override
    public void addTrace(Level level, String origine, Integer value) {
        this.add(new Trace(Calendar.getInstance(), level, origine, new Value(value)));
    }

    @Override
    public void addTrace(Level level, String origine, Float value) {
        this.add(new Trace(Calendar.getInstance(), level, origine, new Value(value)));
    }

    @Override
    public void addTrace(Level level, String origine) {
        this.add(new Trace(Calendar.getInstance(), level, origine));
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

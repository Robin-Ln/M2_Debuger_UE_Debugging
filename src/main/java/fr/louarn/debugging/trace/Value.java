package fr.louarn.debugging.trace;

import fr.louarn.debugging.printer.IDebuggerVisitable;
import fr.louarn.debugging.printer.IDebuggerVisitor;

import java.io.Serializable;
import java.util.Objects;

public class Value implements IDebuggerVisitable, Serializable {

    /**
     * Attributs
     */
    private static final long serialVersionUID = 4L;

    private Object value;

    /**
     * Constructeur
     */
    public Value(Integer value) {
        this.value = value;
    }

    public Value(Double value) {
        this.value = value;
    }

    public Value(String value) {
        this.value = value;
    }

    /**
     * Methodes de l'inerface IDebuggerVisitable
     */

    @Override
    public void accept(IDebuggerVisitor visitor) {
        visitor.visite(this);
    }

    /**
     * Equals et hashcode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return value.equals(value1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Accesseurs
     */
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

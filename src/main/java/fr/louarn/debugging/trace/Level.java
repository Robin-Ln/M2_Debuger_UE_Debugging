package fr.louarn.debugging.trace;

import fr.louarn.debugging.printer.IDebuggerVisitable;
import fr.louarn.debugging.printer.IDebuggerVisitor;

public enum Level implements IDebuggerVisitable {
    /**
     * Valeurs Enumérés
     */

    FAIBLE(1),
    MOYEN(2),
    IMPORTANT(3),
    CRITIQUE(4);

    /**
     * Attributs
     */
    private static final long serialVersionUID = 2L;

    private Integer value;

    /**
     * Constructeurs
     */
    Level(Integer value) {
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
     * Acccesseurs
     */
    public Integer getValue() {
        return value;
    }
}

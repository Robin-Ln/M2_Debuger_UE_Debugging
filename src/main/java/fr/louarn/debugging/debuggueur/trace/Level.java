package fr.louarn.debugging.debuggueur.trace;

import fr.louarn.debugging.debuggueur.printer.IDebuggerVisitable;
import fr.louarn.debugging.debuggueur.printer.IDebuggerVisitor;

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

    private Integer level;

    /**
     * Constructeurs
     */
    Level(Integer level) {
        this.level = level;
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
    public Integer getLevel() {
        return level;
    }
}

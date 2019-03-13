package debuggueur.trace;

import debuggueur.printer.IDebuggerVisitable;

import java.util.Calendar;

public interface ITrace extends IDebuggerVisitable {

    void save(Value value);

    /**
     * Accesseur
     */

    Calendar getCalendar();

    void setCalendar(Calendar calendar);

    Level getLevel();

    void setLevel(Level level);

    String getOrigine();

    void setOrigine(String origine);

    Value getValue();

    void setValue(Value value);
}

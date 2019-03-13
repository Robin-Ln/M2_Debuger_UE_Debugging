package fr.louarn.debugging.debuggueur.printer;


import fr.louarn.debugging.debuggueur.programTrace.ProgramTrace;
import fr.louarn.debugging.debuggueur.trace.Level;
import fr.louarn.debugging.debuggueur.trace.Trace;
import fr.louarn.debugging.debuggueur.trace.Value;
import fr.louarn.debugging.debuggueur.utils.Constants;
import fr.louarn.debugging.debuggueur.utils.PropertiesUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Properties;


class PrinterTest {

    private ProgramTrace programTrace;
    private Level level;

    @BeforeEach
    void init() {
        this.programTrace = new ProgramTrace();
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.FAIBLE, "test", new Value(1)));
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.MOYEN, "test", new Value("test")));
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.CRITIQUE, "test", new Value(1.3)));

        Properties properties = PropertiesUtils.loadProperties(Constants.PATH_PROPERTIES);

        properties.getProperty(Constants.CONF_KEY_LEVEL);

        this.level = Level.valueOf(properties.getProperty(Constants.CONF_KEY_LEVEL));

    }

    @Test
    void test() {
        IDebuggerVisitor visitor = new Printer(System.out, this.level);
        this.programTrace.accept(visitor);

    }

}

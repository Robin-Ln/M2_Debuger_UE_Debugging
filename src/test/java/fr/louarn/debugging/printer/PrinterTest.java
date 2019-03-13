package fr.louarn.debugging.printer;


import fr.louarn.debugging.program.trace.IProgramTrace;
import fr.louarn.debugging.program.trace.ProgramTrace;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Trace;
import fr.louarn.debugging.trace.Value;
import fr.louarn.debugging.utils.Constants;
import fr.louarn.debugging.utils.MethodesUtils;
import fr.louarn.debugging.utils.PropertiesUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Properties;


class PrinterTest {

    private IProgramTrace programTrace;
    private Level level;

    @BeforeEach
    void init() {
        this.programTrace = ProgramTrace.getInstance();
        this.programTrace.addTrace(Level.FAIBLE, "test", new Value(1));
        this.programTrace.addTrace(Level.MOYEN, "test", new Value("test"));
        this.programTrace.addTrace(Level.CRITIQUE, "test", new Value(1.3));

        Properties properties = PropertiesUtils.loadProperties(Constants.PATH_PROPERTIES);

        properties.getProperty(Constants.CONF_KEY_LEVEL);

        this.level = Level.valueOf(properties.getProperty(Constants.CONF_KEY_LEVEL));

    }

    @Test
    void consoleTest() {
        IDebuggerVisitor visitor = new Printer(System.out, this.level);
        this.programTrace.accept(visitor);
    }

    @Test
    void fileTest() {
        PrintStream out = MethodesUtils.createPrintStream(Constants.PATH_TRACE_SAVE);
        IDebuggerVisitor visitor = new Printer(out, this.level);
        this.programTrace.accept(visitor);
        out.close();
    }

}

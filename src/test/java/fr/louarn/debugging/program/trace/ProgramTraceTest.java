package fr.louarn.debugging.program.trace;


import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Trace;
import fr.louarn.debugging.trace.Value;
import fr.louarn.debugging.utils.Constants;
import fr.louarn.debugging.utils.MethodesUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProgramTraceTest {

    private IProgramTrace programTrace;

    @BeforeEach
    void init() {
        this.programTrace = ProgramTrace.getInstance();
        this.programTrace.clear();
        //String methodeName = this.getClass().getEnclosingMethod().getName();
        this.programTrace.addTrace(Level.FAIBLE, "test", 1, new Exception().getStackTrace()[0]);
        this.programTrace.addTrace(Level.FAIBLE, "test","test", new Exception().getStackTrace()[0]);
        this.programTrace.addTrace(Level.FAIBLE, "test", 1.3f, new Exception().getStackTrace()[0]);

    }

    @Test
    void sizeAndValueTest() {
        assertEquals(this.programTrace.size(), 3);
        Assertions.assertEquals(this.programTrace.get(0).getValue(), new Value(1));
        Assertions.assertEquals(this.programTrace.get(1).getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.get(2).getValue(), new Value(1.3f));
        this.programTrace.addTrace(Level.FAIBLE, "test","new", new Exception().getStackTrace()[0]);
        assertEquals(this.programTrace.size(), 4);
        Assertions.assertEquals(this.programTrace.get(3).getValue(), new Value("new"));
    }

    @Test
    void nextTest() {
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1.3f));
        assertThrows(RuntimeException.class, () -> this.programTrace.next());
    }

    @Test
    void revertTest() {
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1.3f));
        assertThrows(RuntimeException.class, () -> this.programTrace.next());
        Assertions.assertEquals(this.programTrace.previous().getValue(), new Value(1.3f));
        Assertions.assertEquals(this.programTrace.previous().getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.previous().getValue(), new Value(1));
        assertThrows(RuntimeException.class, () -> this.programTrace.previous());
    }

    @Test
    void saveReadTest(){
        MethodesUtils.writeObject(this.programTrace, Constants.PATH_FILE_SAVE);

        ProgramTrace programTrace = (ProgramTrace) MethodesUtils.readObject(Constants.PATH_FILE_SAVE);
    }

    @Test
    void rest(){
        String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

        System.out.println(className + "." + methodName + "():" + lineNumber);
    }

}

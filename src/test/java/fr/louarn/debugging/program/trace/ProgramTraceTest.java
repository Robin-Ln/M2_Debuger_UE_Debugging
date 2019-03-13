package fr.louarn.debugging.program.trace;


import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.trace.Trace;
import fr.louarn.debugging.trace.Value;
import fr.louarn.debugging.utils.Constants;
import fr.louarn.debugging.utils.MethodesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProgramTraceTest {

    private ProgramTrace programTrace;

    @BeforeEach
    void init() {
        this.programTrace = new ProgramTrace();
        //String methodeName = this.getClass().getEnclosingMethod().getName();
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.FAIBLE, "test", new Value(1)));
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.FAIBLE, "test", new Value("test")));
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.FAIBLE, "test", new Value(1.3)));

    }

    @Test
    void sizeAndValueTest() {
        assertEquals(this.programTrace.size(), 3);
        Assertions.assertEquals(this.programTrace.get(0).getValue(), new Value(1));
        Assertions.assertEquals(this.programTrace.get(1).getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.get(2).getValue(), new Value(1.3));
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.FAIBLE, "test", new Value("new")));
        assertEquals(this.programTrace.size(), 4);
        Assertions.assertEquals(this.programTrace.get(3).getValue(), new Value("new"));
    }

    @Test
    void nextTest() {
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1.3));
        assertThrows(RuntimeException.class, () -> this.programTrace.next());
    }

    @Test
    void revertTest() {
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.next().getValue(), new Value(1.3));
        assertThrows(RuntimeException.class, () -> this.programTrace.next());
        Assertions.assertEquals(this.programTrace.previous().getValue(), new Value(1.3));
        Assertions.assertEquals(this.programTrace.previous().getValue(), new Value("test"));
        Assertions.assertEquals(this.programTrace.previous().getValue(), new Value(1));
        assertThrows(RuntimeException.class, () -> this.programTrace.previous());
    }

    @Test
    void saveTest(){
        MethodesUtils.writeObject(this.programTrace, Constants.PATH_FILE_SAVE);
    }

    @Test
    void readTest(){
        ProgramTrace programTrace = (ProgramTrace) MethodesUtils.readObject(Constants.PATH_FILE_SAVE);
    }

}
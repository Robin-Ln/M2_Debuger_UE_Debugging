package debuggueur.programTrace;


import debuggueur.trace.Level;
import debuggueur.trace.Trace;
import debuggueur.trace.Value;
import debuggueur.utils.Constants;
import debuggueur.utils.SerializableUtils;
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
        assertEquals(this.programTrace.get(0).getValue(), new Value(1));
        assertEquals(this.programTrace.get(1).getValue(), new Value("test"));
        assertEquals(this.programTrace.get(2).getValue(), new Value(1.3));
        this.programTrace.add(new Trace(Calendar.getInstance(), Level.FAIBLE, "test", new Value("new")));
        assertEquals(this.programTrace.size(), 4);
        assertEquals(this.programTrace.get(3).getValue(), new Value("new"));
    }

    @Test
    void nextTest() {
        assertEquals(this.programTrace.next().getValue(), new Value(1));
        assertEquals(this.programTrace.next().getValue(), new Value("test"));
        assertEquals(this.programTrace.next().getValue(), new Value(1.3));
        assertThrows(RuntimeException.class, () -> this.programTrace.next());
    }

    @Test
    void revertTest() {
        assertEquals(this.programTrace.next().getValue(), new Value(1));
        assertEquals(this.programTrace.next().getValue(), new Value("test"));
        assertEquals(this.programTrace.next().getValue(), new Value(1.3));
        assertThrows(RuntimeException.class, () -> this.programTrace.next());
        assertEquals(this.programTrace.previous().getValue(), new Value(1.3));
        assertEquals(this.programTrace.previous().getValue(), new Value("test"));
        assertEquals(this.programTrace.previous().getValue(), new Value(1));
        assertThrows(RuntimeException.class, () -> this.programTrace.previous());
    }

    @Test
    void saveTest(){
        SerializableUtils.writeObject(this.programTrace, Constants.PATH_FILE_SAVE);
    }

    @Test
    void readTest(){
        ProgramTrace programTrace = (ProgramTrace) SerializableUtils.readObject(Constants.PATH_FILE_SAVE);
    }

}

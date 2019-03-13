package fr.louarn.debugging.debugging;

import fr.louarn.debugging.printer.IDebuggerVisitor;
import fr.louarn.debugging.printer.Printer;
import fr.louarn.debugging.trace.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SensorsSystemTest {

    private SensorsSystem sensorsSystem;

    private IDebuggerVisitor visitor;

    @BeforeEach
    void init (){
        this.sensorsSystem = new SensorsSystem();
        this.visitor = new Printer(System.out, Level.FAIBLE);
    }

    @Test
    void performSensorSweep() {
        Map<String,Float> sensors = this.sensorsSystem.performSensorSweep();
        SensorsSystem.PROGRAM_TRACE.accept(this.visitor);
        assertEquals(sensors.size(), 4);
    }
}

package fr.louarn.debugging.debugging;

import fr.louarn.debugging.program.trace.IProgramTrace;
import fr.louarn.debugging.program.trace.ProgramTrace;
import fr.louarn.debugging.utils.Constants;
import fr.louarn.debugging.utils.MethodesUtils;
import org.apache.log4j.Logger;

import java.util.Map;


public class Run {

    public static final IProgramTrace PROGRAM_TRACE = ProgramTrace.getInstance();


    /**
     * Attribute
     */
    static final Logger logger = Logger.getLogger(Run.class);

    public static void main(String[] args) {
        SensorsSystem system = new SensorsSystem();

        for (int i = 1; i < 10; i++) {
            Map<String, Float> results;
            results = system.performSensorSweep();
            logger.trace("===============================");
            results.forEach((sensorName, sensorValue) -> logger.trace(sensorName + ": " + sensorValue));
        }

        MethodesUtils.writeObject(Run.PROGRAM_TRACE, Constants.PATH_FILE_SAVE);

    }

}

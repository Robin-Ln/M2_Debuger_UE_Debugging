package fr.louarn.debugging.debugging;

import org.apache.log4j.Logger;

import java.util.Map;


public class Run {

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

    }

}

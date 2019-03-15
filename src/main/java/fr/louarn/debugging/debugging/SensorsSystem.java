package fr.louarn.debugging.debugging;

import fr.louarn.debugging.program.trace.IProgramTrace;
import fr.louarn.debugging.program.trace.ProgramTrace;
import fr.louarn.debugging.trace.Level;

import java.util.HashMap;
import java.util.Map;

public class SensorsSystem {

    private Map<String, Sensor> sensors = new HashMap<String, Sensor>();

    public static final IProgramTrace PROGRAM_TRACE = ProgramTrace.getInstance();

    public SensorsSystem() {
        initSensors(sensors);
    }

    private void initSensors(Map<String, Sensor> sensors) {
        sensors.put("Temperature", newSensor("Temperature", 1));
        sensors.put("Humidity", newSensor("Temperature", 2));
        sensors.put("Light", newSensor("Light", 3));
        sensors.put("Sound", newSensor("Sound", 4));
    }

    private Sensor newSensor(String sensorName, int channelIndex) {
        Sensor s = new Sensor();
        s.setName(sensorName);
        s.addToChannel(channelIndex);
        return s;
    }

    public Map<String, Float> performSensorSweep() {
        Map<String, Float> results = new HashMap<String, Float>();
        sensors.forEach((name, sensor) -> readSensorIn(sensor, results));
        return results;
    }

    private void readSensorIn(Sensor s, Map<String, Float> results) {
        SensorsSystem.PROGRAM_TRACE.addTrace(Level.FAIBLE, new Exception().getStackTrace()[0]);
        s.read();
        results.put(s.getName(), s.getValue());
    }

}

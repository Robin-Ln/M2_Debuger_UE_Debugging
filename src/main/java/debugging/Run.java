package debugging;

import java.util.Map;


public class Run {

    public static void main(String[] args) {
        SensorsSystem system = new SensorsSystem();

        for (int i = 1; i < 10; i++) {
            Map<String, Float> results;
            results = system.performSensorSweep();
            System.out.println("===============================");
            results.forEach((sensorName, sensorValue) -> System.out.println(sensorName + ": " + sensorValue) );
        }

    }

}

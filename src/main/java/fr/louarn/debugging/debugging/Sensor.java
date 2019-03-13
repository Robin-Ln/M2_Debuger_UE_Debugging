package fr.louarn.debugging.debugging;

import fr.louarn.debugging.program.trace.IProgramTrace;
import fr.louarn.debugging.program.trace.ProgramTrace;
import fr.louarn.debugging.trace.Level;

public class Sensor {

    public static final IProgramTrace PROGRAM_TRACE = ProgramTrace.getInstance();


    private String name;
    private float value;
    private int rawValue;
    private Channel channel;


    public void addToChannel(int channelIndex) {
        Channel chan = new Channel();
        chan.setIndex(channelIndex);
        this.setChannel(chan);
    }

    public void read() {
        setRawValue(getChannel().read());
        setValue(computeValue());
        Sensor.PROGRAM_TRACE.addTrace(Level.MOYEN,"read(), rawValue : ",this.rawValue);
        Sensor.PROGRAM_TRACE.addTrace(Level.MOYEN,"read(), value : ",this.value);
    }

    public float computeValue() {
        return getRawValue() / 100.0f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getRawValue() {
        return rawValue;
    }

    public void setRawValue(int rawValue) {
        this.rawValue = rawValue;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}

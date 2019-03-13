package fr.louarn.debugging.debugging;

import java.util.Random;

public class Channel {
    private int index;

    public int read() {
        return (new Random()).nextInt(1023);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

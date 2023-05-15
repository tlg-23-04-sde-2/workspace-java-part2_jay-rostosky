package com.entertainment;

import java.util.Objects;

public class Television {
    private String brand;
    private int volume;
    // Television HAS-A Tuner - instantiated internally, not exposed
    private Tuner tuner = new Tuner();

    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    public int getCurrentChannel() {
        return tuner.getChannel();  // delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);  // delegate to contained Tuner object
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        // poorly written hash function, because it easily yields "hash collisions"
        // a "hash collision" is when different objects hash to the same value (dumb luck)
        // return getBrand().length() + getVolume();

        // delegate to Objects.hash(), which uses a "good" hash function to minimize collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // only proceed if 'obj' is a reference to another Television object
        if (obj instanceof Television) {
            // downcast 'obj' to more specific type Television, to call Television methods
            Television other = (Television) obj;

            // do the checks: business equality is defined by brand and volume
            result = Objects.equals(this.getBrand(), other.getBrand()) &&  // null-safe check
                     this.getVolume() == other.getVolume();       // primitives can't be null
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: brand=%s, volume=%s, currentChannel=%s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}
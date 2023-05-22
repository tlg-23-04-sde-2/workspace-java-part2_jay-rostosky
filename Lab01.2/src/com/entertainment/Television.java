package com.entertainment;

import java.util.Objects;

/*
 * Natural order is defined by brand (String).
 *
 * NOTE: to be "consistent with equals," natural order must use the
 * same properties that are used in equals().
 */
public class Television implements Comparable<Television> {
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

    /*
     * Natural order is defined by brand (String), then by volume (int).
     *
     * To be "consistent with equals," we must use the same properties
     * for natural order that we use for equals() and hashCode().
     */
    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {  // tied on brand, break the tie by volume
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
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

        // 'this' (me) and 'obj' refer to the same physical object in memory!
        if (this == obj) {
            result = true;
        }
        // 'obj' is not-null and my Class object is the same as its Class object
        else if (obj != null && (this.getClass() == obj.getClass())) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe
                     this.getVolume() == other.getVolume();  // primitives can't be null
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: brand=%s, volume=%s, currentChannel=%s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}
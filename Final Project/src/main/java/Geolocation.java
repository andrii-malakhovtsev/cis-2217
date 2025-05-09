// Andrii Malakhovtsev
// 05.09.2025
// Final Project - NASA data

import java.io.Serializable;
import java.util.Arrays;

public class Geolocation implements Serializable {
    private String type;
    private double[] coordinates;

    public String toString() {
        return String.format("Geolocation [type=%s, coordinates=%s]", type, Arrays.toString(coordinates));
    }

    public double[] getCoordinates() { return coordinates; }
}

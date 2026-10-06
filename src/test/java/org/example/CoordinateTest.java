package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void equalCoordinatesAreEqual() {
        Coordinate a = new Coordinate(File.E, 2);
        Coordinate b = new Coordinate(File.E, 2);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void differentCoordinatesAreNotEqual() {
        assertNotEquals(new Coordinate(File.E, 2), new Coordinate(File.E, 3));
        assertNotEquals(new Coordinate(File.E, 2), new Coordinate(File.D, 2));
    }
}

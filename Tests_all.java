package travel;

import travel.*;
import travel.flying.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.Test;

//Zhyldyz Zhumabekova 
//G9PZT9

public class Tests_all {

    @Test
    public void chech_date_and_time() {
        DateAndTime dat1 = new DateAndTime();
        DateAndTime dat2 = new DateAndTime(2021, 12, 25, 03, 10);
        DateAndTime dat3 = new DateAndTime(2021, 12, 25, 03, 10);
        assertEquals(dat3, dat3);
        assertNotEquals(dat1, dat2);
    }

    @Test
    public void chech_Destination_utils() {
        assertEquals(Destination.ROME, DestinationUtils.getDestination("01:45"));
        assertEquals("02:05", DestinationUtils.getDestinationDuration(Destination.AMSTERDAM));
    }

    @Test
    public void check_flying_equals() {
        Plane plane1 = new Plane("Bo 896", 1, 100);
        Plane plane2 = new Plane("Bo 896", 1, 100);
        Plane plane3 = new Plane("Airbus A328", 2, 98);

        assertTrue(plane1.equals(plane2));
        assertFalse(plane1.equals(plane3));

    }

    @Test
    public void check_flying_hashCode() {
        Plane p1 = new Plane("Airbus2 A560", 123, 100);
        Plane p2 = new Plane("Airbus2 A560", 123, 100);
        Plane p3 = new Plane("Bo 896", 456, 200);

        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    public void check_estimatedArrivalTime() {
        Plane p = new Plane("Airbus 712", 90, 18);

        assertEquals(17, p.estimatedArrivalTime(Destination.ROME, 15));
        assertNotEquals(23, p.estimatedArrivalTime(Destination.PARIS, 15));
    }

    @Test // (expected = IOException.class)
    public void check_save() {
        DateAndTime dat2 = new DateAndTime(2021, 12, 25, 03, 10);
        Plane p1 = new Plane("Airbus2 A560", 123, 100);
        Plane p2 = new Plane("Airbus2 A560", 123, 100);
        Plane p3 = new Plane("Bo 896", 456, 200);
        Plane[] plane_arr = { p1, p2, p3 };
        FlightWithManyPlanes flights = new FlightWithManyPlanes("Airbus 712", Destination.PARIS, 18, dat2, plane_arr);
        assertThrows(IOException.class, () -> {
            flights.save("hellop-/.txt");
        });

        assertThrows(IOException.class, () -> {
            flights.save("abc/.txt");
        });

    }

    @Test
    public void check_load() {
        DateAndTime dat2 = new DateAndTime(2021, 12, 25, 03, 10);
        Plane p1 = new Plane("Airbus2 A560", 123, 100);
        Plane p2 = new Plane("Airbus2 A560", 123, 100);
        Plane p3 = new Plane("Bo 896", 456, 200);
        Plane[] plane_arr = { p1, p2, p3 };
        FlightWithManyPlanes flights0 = new FlightWithManyPlanes("Airbus 71", Destination.AMSTERDAM, 18, dat2,
                plane_arr);
        FlightWithManyPlanes flights = new FlightWithManyPlanes("Airbus 712", Destination.PARIS, 18, dat2, plane_arr);
        assertThrows(IOException.class, () -> {
            flights.load("hello/.txt");
        });

        assertThrows(IOException.class, () -> {
            flights.load("lol/.txt");
        });
    }

}
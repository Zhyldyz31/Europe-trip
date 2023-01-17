package travel;

import travel.Destination;
import travel.DestinationUtils;
import travel.DateAndTime;
import travel.flying.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DateAndTime dat = new DateAndTime(12, 5, 8, 12, 55);
        // System.out.println(dat.exact_date());
        Flight flight = new Flight();
        // System.out.println(flight.getFlightDuration());
        // System.out.println(DestinationUtils.getRoundedHours(Destination.BERLIN));
        Plane[] planes={new Plane("rr",13,55),new Plane("re",11,50),new Plane("rp",15,22)};
        FlightWithManyPlanes flight_2 = new FlightWithManyPlanes("AirBus", Destination.AMSTERDAM, 45, dat, planes);
        Plane plane =flight_2.getCheapestRide(1.55);
        System.out.println(plane.get_name());
        String name = "AirBus";
       
        flight_2.save("abc.txt");
        FlightWithManyPlanes fl_many_planes = flight_2.load("abc.txt");
        System.out.println(fl_many_planes.get_destinationCity());

    }
}

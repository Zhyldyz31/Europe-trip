package travel.flying;

import travel.DateAndTime;
import travel.Destination;
import travel.DestinationUtils;

public class Flight {

    protected String name;
    protected Destination destinationCity;
    protected int numberOfTravellers;
    protected DateAndTime flightDateAndTime;

    public String get_name() {
        return this.name;
    }

    public Destination get_destinationCity() {
        return this.destinationCity;
    }

    public int get_numberOfTravellers() {
        return this.numberOfTravellers;
    }

    public String get_flightDateAndTime() {
        String dateAndTime_str = this.flightDateAndTime.exact_date();
        return dateAndTime_str;
    }

    public Flight(String name, Destination destinationCity, int numberOfTravellers, DateAndTime flightDateAndTime) {
        // if (this.numberOfTravellers < 15 || this.numberOfTravellers > 100) {
        // throw new IllegalArgumentException();}

        this.name = name;
        this.destinationCity = destinationCity;
        this.numberOfTravellers = numberOfTravellers;
        this.flightDateAndTime = flightDateAndTime;

    }

    public Flight() {
        // if I initialise only this line I have some errors
        Flight flight = new Flight("AirBus", Destination.ROME, 83, new DateAndTime(2002, 9, 5, 12, 8));
        this.name = "AirBus";
        this.destinationCity = Destination.ROME;
        this.numberOfTravellers = 83;
        this.flightDateAndTime = new DateAndTime(2002, 9, 5, 12, 8);
    }

    public String getFlightDuration() {
        return String.valueOf(DestinationUtils.getRoundedHours(this.destinationCity));
    }
}

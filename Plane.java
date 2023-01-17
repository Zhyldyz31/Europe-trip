package travel.flying;

import travel.Destination;
import travel.DestinationUtils;

public class Plane extends Flight implements Flyable {
    
    public double discountRate(double discountRate) {
        return discountRate;
    }
    public int estimatedArrivalTime(Destination destination, int departHour) {
        int estimatedArrival = departHour + DestinationUtils.getRoundedHours(destination);
        if (estimatedArrival >= 24) {
            estimatedArrival -= 24;
        }
        return estimatedArrival;
    }

    public String name;
    public int id;
    public int ticketPrice;

    public String get_name() {
        return this.name;
    }

    public int get_id() {
        return this.id;
    }

    public int get_ticketPrice() {
        return this.ticketPrice;
    }

    public Plane(String name, int id, int ticketPrice) {
        if (name.equals(null) || ticketPrice < 15) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.id = id;
        this.ticketPrice = ticketPrice;
    }

    public static Plane make(String data) {
        String[] arr_data = data.split(",");
        String name = arr_data[0];
        int id = Integer.valueOf(arr_data[1]);
        int ticketPrice = Integer.valueOf(arr_data[2]);
        return new Plane(name, id, ticketPrice);
    }
   
    @Override
    public boolean equals(Object p) {
        if (p == this) {
            return true;
        }
        if (!(p instanceof Plane)) {
            return false;
        }
        Plane p1 = (Plane) p;

        return Integer.compare(p1.id, id) == 0 && Integer.compare(p1.ticketPrice, ticketPrice) == 0 && p1.name.compareTo(name)==0;
    }

    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.id;
        result = 31 * result + this.ticketPrice;
        return result;
    }
}

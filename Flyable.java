package travel.flying;

import travel.Destination;

public interface Flyable {
    public int estimatedArrivalTime(Destination destination, int departHour);

    public double discountRate(double discountRate);
}
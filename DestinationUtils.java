package travel;

public class DestinationUtils {
    public static Destination getDestination(String travel_duration) {
        if (travel_duration.equals("01:34"))
            return Destination.BERLIN;
        else if (travel_duration.equals("01:45"))
            return Destination.ROME;
        else if (travel_duration.equals("02:05"))
            return Destination.AMSTERDAM;
        else if (travel_duration.equals("02:20"))
            return Destination.PARIS;
        else if (travel_duration.equals("02:43"))
            return Destination.HELSINKI;
        else
            return null;
    }

    public static String getDestinationDuration(Destination destionation) {
        if (destionation.equals(Destination.BERLIN))
            return " 01:34";
        else if (destionation.equals(Destination.ROME))
            return "01:45";
        else if (destionation.equals(Destination.AMSTERDAM))
            return "02:05";
        else if (destionation.equals(Destination.PARIS))
            return "02:20";
        else if (destionation.equals(Destination.HELSINKI))
            return "02:43";
        else
            return null;
    }

    public static int getRoundedHours(Destination destionation) {
        String dest_duration = DestinationUtils.getDestinationDuration(destionation);
        String[] arrayofStrings = dest_duration.split(":");
        String hoursStr = String.valueOf(arrayofStrings[0]);
        int hours = Integer.valueOf(String.valueOf(hoursStr.charAt(1)));
        int minute = Integer.valueOf(arrayofStrings[1]);
        System.out.println(minute);
        if (minute > 30) {
            return hours + 1;
        }
        return hours;

    }

}

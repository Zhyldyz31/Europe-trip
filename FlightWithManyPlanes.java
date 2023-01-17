package travel.flying;
import travel.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

import java.util.Arrays;
import java.util.List;
public class FlightWithManyPlanes extends Flight{
    public List <Plane> planes;
    public FlightWithManyPlanes(String name, Destination destinationCity, int numberOfTravellers, DateAndTime flightDateAndTime,Plane... planes_arr){
        super(name,destinationCity,numberOfTravellers,flightDateAndTime);
        this.planes=Arrays.asList(planes_arr);
    }
    
    public void save(String filename) throws IOException{
       
        StringBuilder string_b = new StringBuilder();
        DateAndTime dat = new DateAndTime(12, 5, 8, 12, 55);
        Flight flight=new Flight("AirBus",Destination.PARIS,61,dat);
        string_b.append(flight.get_name()).append("\n");
        string_b.append(flight.get_destinationCity()).append("\n");
        string_b.append(flight.get_numberOfTravellers()).append("\n");
        string_b.append(flight.get_flightDateAndTime()).append("\n");
        String content = string_b.toString();
        Files.write(Paths.get(filename), content.getBytes());
    }

        public FlightWithManyPlanes load (String filename) throws IOException{
        List<String> lines=Files.readAllLines(Paths.get(filename));
        String name=lines.get(0);
        String destinationCityString=lines.get(1);
        Destination dest_city=Destination.valueOf(destinationCityString);
        int numberOfTravellers=Integer.parseInt(lines.get(2));
     
        Plane[] planes=new Plane[0];
        DateAndTime dat=new DateAndTime();
        FlightWithManyPlanes load_flight = new FlightWithManyPlanes(name,dest_city,numberOfTravellers,dat,planes);
        return load_flight;
    }
        public Plane getCheapestRide(double discountRateIncrease){
            if (this.planes.isEmpty()){
                throw new IllegalStateException();
            }
            double min=planes.get(1).get_ticketPrice()*discountRateIncrease;
            Plane plane=planes.get(1);
            for(int i=2;i<this.planes.size();i++){
               if(planes.get(i).get_ticketPrice()*discountRateIncrease*i<min){
                    min=planes.get(i).get_ticketPrice()*discountRateIncrease*i;
                    plane=planes.get(i);
               }
               else {
                    continue;
               }
               
            }
            return plane;
     
    }

}

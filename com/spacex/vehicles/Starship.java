// Starship.java
// W. Geesey 
// 3/20/23
// class representing SpaceX Starship

package com.spacex.vehicles;

import com.spacex.personnel.Astronaut;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.Period;
import java.time.LocalDate;
import java.text.DecimalFormat;

// "As the most powerful launch system ever developed, Starship will be able
// to carry up to 100 people on long-duration, interplanetary flights."
// https://www.spacex.com/vehicles/starship


public class Starship {
    private static int MAX_ASTRONAUTS = 100;
    private String name;
    private double weightKg;  // weight in kg
    private double altitudeKm; // altitude in kilometers
    ArrayList<Astronaut> astronauts = new ArrayList<>();
    
    public static void main(String[] args) {
    
        // create a space station and display it
        Starship ss = new Starship("SN15", 4989516.07 /* base weight: 11M lbs*/);
        System.out.println(ss);

        // add some astronauts
        System.out.println("Adding astronauts!\n");
        
        // Crew 1: https://blogs.nasa.gov/crew-1/
        // Crew 2: https://blogs.nasa.gov/crew-2/
        // Crew 3: https://blogs.nasa.gov/crew-3/
        // Crew 4: https://blogs.nasa.gov/crew-4/
        // Crew 5: https://blogs.nasa.gov/crew-5/
        // Crew-6: https://blogs.nasa.gov/crew-6/
        
        // "In general, astronauts should weigh between 50 and 95 kilograms (110 and 209 pounds) 
        // " and measure between 149.5cm and 190.5cm."
        // https://nypost.com/2022/02/13/what-does-it-take-to-be-a-nasa-astronaut/
        
        final double MIN_WT = 50, MAX_WT = 95; // cm
        final double MIN_HT = 149.5, MAX_HT = 190.5; // cm
        
        ss.addAstronaut("Megan McArthur", 
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT));
        ss.addAstronaut("Woody Hoburg",
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT));
        ss.addAstronaut("Andrey Fedyaev", 
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT));
        ss.addAstronaut("Shannon Walker", 
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT));
        ss.addAstronaut("Jessica Watkins",
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT));
        ss.addAstronaut("Koichi Wakata",
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT));
        ss.addAstronaut("Matthias Maurer",
              getRandomInRange(MIN_WT, MAX_WT), getRandomInRange(MIN_HT, MAX_HT)); 
        
        // set the altitude (low-earth orbit max
        // https://www.nasa.gov/leo-economy/faqs)
        ss.setAltitude(2000.0);
        
        // show the new state
        System.out.println(ss);
    }
    
    // overload, create a space station object with specified name and weight
    public Starship(String name, double weightKg) {
        this.name = name;
        this.weightKg = weightKg;
        this.altitudeKm = 0;
    }
    
    public static double getRandomInRange(double min, double max) {
        return(Math.random() * (max - min) + min);
    }
    
    // add an astronaut
    public void addAstronaut(String name, 
                double heightCm, double weightKg) {
        LocalDateTime ldtArrival = LocalDateTime.now();
        Period stayPeriod = Period.of(0, 0, 60);
        LocalDate departure = ldtArrival.toLocalDate().plus(stayPeriod);
        astronauts.add(new Astronaut(name, heightCm, weightKg, ldtArrival, stayPeriod, departure));
        this.weightKg += weightKg;
    }
    
    // set the altitude
    public void setAltitude(double altitudeKm) {
        this.altitudeKm = altitudeKm;
    }
    
    // show the space station
    public String toString() {
        DecimalFormat df = new DecimalFormat(".#");
        String ss = "Starship: " + name + "\n" +
               "Weight (kg):   " + df.format(weightKg) + "\n" +
               "Altitude (km): " + altitudeKm + "\n" +
               "Astronauts:    " + astronauts.size() + "\n" +
               ((astronauts.size() > 0) ? "Astronaut Details:\n\n" : "");
               
        for (Astronaut a : astronauts)
            ss += a + "\n";
            
        return ss;
    }           
}

// Astronaut.java
// W. Geesey
// 3/20/23
// Class representing an astronaut

package com.spacex.personnel;

import java.time.LocalDateTime;
import java.text.DecimalFormat;
import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Astronaut {
    private String name;
    private double heightCm;  // height in centimeters
    private double weightKg;  // weight in kilograms
    private LocalDateTime arrival; // arrival date/time
    private Period lengthOfStay;
    private LocalDate departureDate;
    
    // overload, create an astronaut with specified name, height, and weight
    public Astronaut(String name, double heightCm, double weightKg,
                     LocalDateTime arrival, Period lengthOfStay,
                     LocalDate departureDate) {
        this.name = name;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.arrival = arrival;
        this.lengthOfStay = lengthOfStay;
        this.departureDate = departureDate;
    }
     
    @Override
    public String toString() {
        DecimalFormat decFormatter = new DecimalFormat(".#");
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter departureFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        return "name: " + name + "\n" + 
               "height: " + decFormatter.format(heightCm) + " (cm)\n" +
               "weight: " + decFormatter.format(weightKg) + " (kg)\n" +
               "arrival: " + dtFormatter.format(arrival) + "\n" + 
               "Length of Stay: " + lengthOfStay.getDays() + " days\n" +
               "Departure date: " + departureFormatter.format(departureDate) + "\n";
    }
}

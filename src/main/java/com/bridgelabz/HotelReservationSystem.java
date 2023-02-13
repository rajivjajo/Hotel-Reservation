package com.bridgelabz;

import com.bridgelabz.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {

    public static void main(String[] args) {

        List<Hotel> hotels = new ArrayList<>();

        hotels.add(new Hotel("Lakewood", 3, 110, 80, 90, 80));
        hotels.add(new Hotel("Bridgewood", 4, 160, 110, 60, 50));
        hotels.add(new Hotel("Ridgewood", 5, 220, 100, 150, 40));

        LocalDate fromDate = LocalDate.parse("2022-05-23");
        LocalDate toDate = LocalDate.parse("2022-05-31");

        String customerType = "regular";

        Hotel cheapestHotel = findCheapestHotel(hotels, fromDate, toDate, customerType);
        System.out.println("The cheapest hotel is: " + cheapestHotel.getName());
    }

    private static Hotel findCheapestHotel(List<Hotel> hotels, LocalDate fromDate, LocalDate toDate, String customerType) {
        return hotels.stream()
                .min((h1, h2) -> (int) (h1.getTotalPrice(fromDate, toDate, customerType) - h2.getTotalPrice(fromDate, toDate, customerType)))
                .orElse(null);
    }
}

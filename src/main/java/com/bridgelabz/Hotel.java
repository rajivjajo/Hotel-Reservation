package com.bridgelabz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Hotel {
    private String name;
    private int rating;
    private int weekdayRegularRate;
    private int weekdayRewardsRate;
    private int weekendRegularRate;
    private int weekendRewardsRate;

    public Hotel(String name, int rating, int weekdayRegularRate, int weekdayRewardsRate, int weekendRegularRate, int weekendRewardsRate) {
        this.name = name;
        this.rating = rating;
        this.weekdayRegularRate = weekdayRegularRate;
        this.weekdayRewardsRate = weekdayRewardsRate;
        this.weekendRegularRate = weekendRegularRate;
        this.weekendRewardsRate = weekendRewardsRate;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getWeekdayRegularRate() {
        return weekdayRegularRate;
    }

    public int getWeekdayRewardsRate() {
        return weekdayRewardsRate;
    }

    public int getWeekendRegularRate() {
        return weekendRegularRate;
    }

    public int getWeekendRewardsRate() {
        return weekendRewardsRate;
    }

    public int getTotalPrice(LocalDate fromDate, LocalDate toDate, String customerType) {
        int totalPrice = 0;
        long numberOfDays = ChronoUnit.DAYS.between(fromDate, toDate) + 1;
        for (int i = 0; i < numberOfDays; i++) {
            LocalDate currentDate = fromDate.plusDays(i);
            if (currentDate.getDayOfWeek().getValue() >= 6) {
                if (customerType.equals("regular")) {
                    totalPrice += weekendRegularRate;
                } else {
                    totalPrice += weekendRewardsRate;
                }
            } else {
                if (customerType.equals("regular")) {
                    totalPrice += weekdayRegularRate;
                } else {
                    totalPrice += weekdayRewardsRate;
                }
            }
        }
        return totalPrice;
    }}
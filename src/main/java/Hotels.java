import java.time.LocalDate;

public class Hotels {
    private String name;
    private int rating;
    private int weekdayRegularRate;
    private int weekdayRewardRates;
    private int weekendRegularRate;
    private int weekendRewardRates;

    public Hotels(String name, int rating, int weekdayRegularRate, int weekdayRewardRates, int weekdaysRatesRewardsCustomer, int weekendRewardRates) {
        this.name = name;
        this.rating = rating;
        this.weekdayRegularRate = weekdayRegularRate;
        this.weekdayRewardRates = weekdayRewardRates;
        this.weekendRegularRate = weekdaysRatesRewardsCustomer;
        this.weekendRewardRates = weekendRewardRates;
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

    public int getWeekdayRewardRates() {
        return weekdayRewardRates;
    }

    public int getWeekendRegularRate() {
        return weekendRegularRate;
    }

    public int getWeekendRewardRates() {
        return weekendRewardRates;
    }

    public int getRate(LocalDate date, boolean isRewardsCustomer) {
        boolean isWeekday = date.getDayOfWeek().getValue() >= 1 && date.getDayOfWeek().getValue() <= 5;
        if (isWeekday) {
            return isRewardsCustomer ? weekdayRewardRates : weekdayRegularRate;
        }else {
            return isRewardsCustomer ? weekendRewardRates : weekendRegularRate;
        }
    }
}

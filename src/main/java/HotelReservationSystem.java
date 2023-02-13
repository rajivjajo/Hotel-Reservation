import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HotelReservationSystem {
    private static List<Hotels> hotels = Arrays.asList(
            new Hotels("Lakewood",3,110,80,90,80),
            new Hotels("Bridgewood",4,160,110,60,50),
            new Hotels("Ridgewood",5,220,100,50,40)
    );
    public static int main(String[] args) {
        String fromDateStr ="23-05-2022";
        String toDateStr = "31-05-2022";
        boolean isRewardsCustomer = false;
        LocalDate fromDate = LocalDate.parse(fromDateStr);
        LocalDate toDate = LocalDate.parse(toDateStr);

        String cheapestHotel = hotels.stream().min(h1,h2) -> {
            int h1Total = 0;
            int h2Total = 0;
            for (LocalDate date = fromDate; date.isBefore(toDate.plusDays(1)); date =date.plusDays(1)) {
                h1Total += h1.getRate(date, isRewardsCustomer);
                h2Total += h2.getRate(date, isRewardsCustomer);
            }
            return h1Total - h2Total;
        }). = Math.min(Hotels::getName )
                .orElse("NO hotel found");
        System.out.println("Cheapest Hotel is "+cheapestHotel);
        }

    }




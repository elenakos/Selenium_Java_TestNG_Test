import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilities {
    private WebDriver driver;
    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    public String returnTodayDate() {
        // Get the current date
        LocalDate today = LocalDate.now();
        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // Format the LocalDate object into a String
        String formattedDate = today.format(formatter);
        System.out.println("Today's date (MM/dd/yyyy): " + formattedDate);
        return formattedDate;
    }

    public String addDaysToDate(int days) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedFutureDate = futureDate.format(formatter);
        System.out.println("Generated date (MM/dd/yyyy): " + formattedFutureDate);
        return formattedFutureDate;

    }

    public String transformDateToMMDDYYYY(String date) {
        DateTimeFormatter formatterGiven = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate formattedDate = LocalDate.parse(date, formatterGiven);
        return formattedDate.format(formatter);
    }
}

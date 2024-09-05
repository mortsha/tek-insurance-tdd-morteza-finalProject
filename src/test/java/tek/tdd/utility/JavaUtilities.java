package tek.tdd.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class JavaUtilities {
    public static void main(String[] args) {

        LocalDate todaydate = LocalDate.now(ZoneId.of("-05:00"));
        System.out.println(todaydate);


    }

    public static String getRandomEmail(String name) {
        int randomNumber = (int) (Math.random() * 10000);
        return name + +randomNumber + "@happy.ca";
    }

    public static LocalDate getTodayDate(int plusDays){
        return LocalDate.now().plusDays(plusDays);
    }

    public static DateTimeFormatter dateFormatter(String pattern){
        return DateTimeFormatter.ofPattern(pattern);
    }
}

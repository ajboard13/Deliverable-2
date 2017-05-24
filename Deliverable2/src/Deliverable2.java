import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Created by Aaron on 5/24/2017.
 */
public class Deliverable2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String date1;
        String date2;
        LocalDate parsedDate1;
        LocalDate parsedDate2;

        //prompting for user input
        System.out.println("Enter two dates in yyyy-mm-dd format, and I will find the duration between them");
        System.out.println("Enter the first date in yyyy-mm-dd format (include dashes):");
        date1 = input.nextLine();
        System.out.println("Enter the second date in yyyy-mm-dd format (include dashes):");
        date2 = input.nextLine();

        //parsing the dates
        parsedDate1 = parseDate(date1);
        parsedDate2 = parseDate(date2);
        LocalDate parseDate2MinusAMonth = parsedDate2.minusMonths(1);
        int monthLength = parseDate2MinusAMonth.lengthOfMonth();


        //finding the difference in time in each unit
        long diffDays = ChronoUnit.DAYS.between(parsedDate1, parsedDate2);
        long diffMonths = ChronoUnit.MONTHS.between(parsedDate1, parsedDate2);
        long diffYears = ChronoUnit.YEARS.between(parsedDate1, parsedDate2);

        // displaying the calculated differences
        System.out.println("The duration in days is: "+ diffDays);
        System.out.println("The duration in months is: "+diffMonths);
        System.out.println("The duration in years is: "+diffYears);

        diffMonths = differenceInMonths(diffMonths, diffYears);
        if((parsedDate2.getDayOfMonth() - parsedDate1.getDayOfMonth()) < 0){
            diffDays = (parsedDate2.getDayOfMonth() - parsedDate1.getDayOfMonth());
            diffDays += monthLength;
        }
        else{
            diffDays = (parsedDate2.getDayOfMonth() - parsedDate1.getDayOfMonth());
        }

        // showing the total time in the simplest form
        System.out.println("The total time between these dates is: " + diffYears +" years, "+ diffMonths + " months, and "+ diffDays + " days.");
    }



    //method to parse dates
    private static LocalDate parseDate(String date){
        LocalDate parsedDate = LocalDate.parse(date);
        return parsedDate;
    }


    //calculating the difference in months and catching zero division error
    private static long differenceInMonths(long diffMonths, long diffYears){
        long differenceInMonths = diffMonths;
        if (diffYears != 0){
            differenceInMonths = diffMonths % 12;
        }
        return differenceInMonths;
    }
}

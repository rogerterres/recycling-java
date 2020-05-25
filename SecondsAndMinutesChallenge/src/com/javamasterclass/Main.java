package com.javamasterclass;

public class Main {

    //
    // Create a method called getDurationString with two parameters, first parameter is minutes
    // and 2nd parameter is seconds
    // You should validate that the first parameter minutes is >= 0.
    // You should validate that the 2nd parameter seconds is >= 0 and <= 59.
    // Return "Invalid value" in the method if either of the above is not true
    // If the parameters are valid then calculate how many hours minutes and seconds
    // comprise the minutes and seconds passed to this method and return that value
    // as string in format "XXh XXm XXs" where XX represents a number of hours minutes and seconds
    // Create a 2nd method of the same name but with only one parameter seconds
    // Validate that it is >= 0, and return "Invalid value" if it is not true
    // If it is valid, then calculate how many minutes are in the seconds and then
    // call the other overloaded method passing the correct minutes and seconds calculated so
    // that it can calculate correctly
    // Call both methods to print values in main method
    //
    // Tips:
    // Use int or long for your number data types is probably a good idea
    // 1 minute = 60 seconds and 1 hour = 60 minutes = 3600 seconds
    // Methods should be stati currently we are only using static methods
    //
    // Bonus:
    // For the input 61 minutes output should be 01h 01m 00s, but it is ok if it is 1h 1m 0s (Tip: use if-else)
    // Create new project with name SecondsAndMinutesChallenge
    //

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {

        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945L));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65, 9));
    }

    private static String getDurationString(long minutes, long seconds) {
        if((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return INVALID_VALUE_MESSAGE;
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hoursString = hours + "h";
        if (hours < 10) {
            hoursString = "0" + hoursString;
        }

        String minutesString = remainingMinutes + "m";
        if (remainingMinutes < 10) {
            minutesString = "0" + minutesString;
        }

        String secondsString = seconds + "s";
        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }

        return hoursString + " "+ minutesString + " " + secondsString + "";
    }

    private static String getDurationString(long seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }
}

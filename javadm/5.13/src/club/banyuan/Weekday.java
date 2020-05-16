package club.banyuan;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    boolean isWeekDay() {
        return ordinal() <= 4;
    }

    boolean isHoliday() {
        return !isWeekDay();
    }

}
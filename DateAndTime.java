package travel;

public class DateAndTime {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public int get_year() {
        return this.year;
    }

    public int get_month() {
        return this.month;
    }

    public int get_day() {
        return this.day;
    }

    public int get_hour() {
        return this.hour;
    }

    public int get_minute() {
        return this.minute;
    }

    public DateAndTime(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public DateAndTime() {

        this.year = 2021;
        this.month = 12;
        this.day = 22;
        this.hour = 4;
        this.minute = 30;
    }

    public String getTime() {
        return this.hour + ":" + this.minute;
    }

    public String exact_date() {
        return this.year + "." + this.month + "." + this.day + " at " + this.hour + ":" + this.minute;

    }

}
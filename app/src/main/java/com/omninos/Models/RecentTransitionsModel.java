package com.omninos.Models;

public class RecentTransitionsModel {

    String DriverName;
    String Prices;
    String From;
    String To;
    String Date;

    public RecentTransitionsModel(String driverName, String prices, String from, String to, String date) {
        DriverName = driverName;
        Prices = prices;
        From = from;
        To = to;
        Date = date;
    }

    public String getDriverName() {
        return DriverName;
    }

    public String getPrices() {
        return Prices;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public String getDate() {
        return Date;
    }
}

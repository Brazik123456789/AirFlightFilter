package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {

        AirFlightFilter dataFiltering = new AirFlightFilter();
        dataFiltering.printList(FlightBuilder.createFlights());

        dataFiltering.departureToTheCurrentTime(FlightBuilder.createFlights());

        dataFiltering.segmentsWithArrivalDateBeforeDepartureDate(FlightBuilder.createFlights());

        dataFiltering.totalTimeSpentOnTheGroundMoreThanTwoHours(FlightBuilder.createFlights());
    }
}

package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AirFlightFilter {

    public void printList(List<Flight> flightList){
        System.out.println("все рейсы:");
        flightList.forEach(System.out::println);
        System.out.println("--------------------------------");
    }

    public void departureToTheCurrentTime(List<Flight> flightList)
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("1. Вылет до текущего момента времени");
        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getDepartureDate().isBefore(now))
                .forEach(segment -> System.out.println(segment.toString())));
    }

    public void segmentsWithArrivalDateBeforeDepartureDate(List<Flight> flightList) {
        System.out.println("2. Имеются сегменты с датой прилёта раньше даты вылета");
        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                .forEach(segment -> System.out.println(segment.toString())));
    }

    public void totalTimeSpentOnTheGroundMoreThanTwoHours(List<Flight> flightList) {
        System.out.println("3. Общее время, проведённое на земле превышает два часа");
        int count = 0;
        boolean isBreak = false;
        for (Flight flight: flightList
        ) {
            isBreak = false;
            count = 0;
            if (flight.getSegments().size() > 1) {
                for (int indexSegment = 0; indexSegment < flight.getSegments().size() - 1; indexSegment++) {
                    for (int indexNextSegment = indexSegment + 1; indexNextSegment < flight.getSegments().size(); indexNextSegment++) {
                        if (between(flight.getSegments().get(indexSegment).getArrivalDate(),
                                flight.getSegments().get(indexNextSegment).getDepartureDate()) <= 2) {

                            count += between(flight.getSegments().get(indexSegment).getArrivalDate(),
                                    flight.getSegments().get(indexNextSegment).getDepartureDate());
                            indexSegment++;
                        } else {
                            System.out.println(flight.getSegments());
                            isBreak = true;
                            break;
                        }
                    }
                    if (isBreak)
                        break;
                }
                if (!isBreak & count > 2)
                    System.out.println(flight.getSegments());
            }
        }
    }

    public int between(LocalDateTime data1, LocalDateTime data2){

        return (int) ChronoUnit.HOURS.between(data1,data2);
    }
}

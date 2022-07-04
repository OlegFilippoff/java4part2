package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class TicketsData implements Comparable<TicketsData> {
    private int id;
    private int ticketPrice;
    private String departure;
    private String arrival;
    private int flightDuration;


    @Override
    public int compareTo(TicketsData o) {
        if (this.ticketPrice > o.getTicketPrice())
        {
            return 1;
        }
        else if (this.ticketPrice < o.getTicketPrice()) {
            return  - 1;
        }
        else {
            return 0;
        }

    }
}

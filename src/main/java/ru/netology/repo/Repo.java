package ru.netology.repo;

import ru.netology.domain.TicketsData;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Repo {
    TicketsData data = new TicketsData();
    TicketsData[] tickets = new TicketsData[0];

    public void addTicket(TicketsData ticket) {
        TicketsData[] tmp = new TicketsData[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public TicketsData[] findAllNotSpecific() {
        return tickets;
    }

    public TicketsData[] findAll(String departure, String arrival) {
        TicketsData[] tmp = new TicketsData[tickets.length];
        int index = 0;
        for (TicketsData ticket:tickets
             ) {
            if (ticket.getDeparture().equals(departure) && ticket.getArrival().equals(arrival)) {
                tmp[index] = ticket;
                index++;
            }
        }
        TicketsData[] result = new TicketsData[index];
        System.arraycopy(tmp,0,result,0,result.length);
        tickets = result;
        Arrays.sort(tickets);
        return tickets;
    }

    public TicketsData findById(int id) {
        for (TicketsData ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) throws RuntimeException, IndexOutOfBoundsException {
        if (findById(id) == null) {
            throw new RuntimeException("Ошибка");
        }
        int length = tickets.length - 1;
        TicketsData[] tmp = new TicketsData[length];
        int index = 0;
        for (TicketsData ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;

    }

}



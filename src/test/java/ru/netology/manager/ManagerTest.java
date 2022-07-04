package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsData;
import ru.netology.repo.Repo;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Repo repo = new Repo();
    Manager manager = new Manager(repo);

    TicketsData ticket1 = new TicketsData(1,1_500,"IRK","VKO",5);
    TicketsData ticket2 = new TicketsData(2,5000,"SVO", "NCE", 3);
    TicketsData ticket3 = new TicketsData(3, 2500, "PAS", "ATE", 8);
    TicketsData ticket4 = new TicketsData(4,8500,"DME", "KRD", 4);
    TicketsData ticket5 = new TicketsData(5,6000,"MMI", "LAC", 7);
    TicketsData ticket6 = new TicketsData(6, 3_000, "IRK", "VKO", 5);
    TicketsData ticket7 = new TicketsData(7, 2_500, "IRK", "VKO", 5);
    TicketsData ticket8 = new TicketsData(8, 2_600, "IRK", "VKO", 5);
    TicketsData ticket9 = new TicketsData(9, 2_600, "IRK", "VKO", 5);


    @Test
    void showAllEight () {
        manager.buyTicket(ticket1);
        manager.buyTicket(ticket2);
        manager.buyTicket(ticket3);
        manager.buyTicket(ticket4);
        manager.buyTicket(ticket5);
        manager.buyTicket(ticket6);
        manager.buyTicket(ticket7);
        manager.buyTicket(ticket8);
        manager.buyTicket(ticket9);



        TicketsData[] expected = {ticket1, ticket7, ticket8, ticket9, ticket6};
        TicketsData[] actual = manager.showAll("IRK","VKO");

        assertArrayEquals(expected, actual);

    }

    @Test
    void buyTicketAndFindItByArrival() {
        manager.buyTicket(ticket1);
        manager.buyTicket(ticket2);
        TicketsData[] expected = {ticket1};
        TicketsData[] actual = manager.showAll("IRK","VKO");

        assertArrayEquals(expected, actual);
    } @Test
    void buyTicketAndFindItByDeparture() {

        manager.buyTicket(ticket1);
        manager.buyTicket(ticket2);
        manager.buyTicket(ticket6);

        TicketsData[] expected = {ticket1, ticket6};
        TicketsData[] actual = manager.showAll("IRK","VKO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteTicket() {
        manager.buyTicket(ticket1);
        manager.buyTicket(ticket3);
        manager.buyTicket(ticket2);
        manager.deleteTicket(2);
        TicketsData[] expected = {ticket1};
        TicketsData[] actual = manager.showAll("IRK", "VKO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteTicketAndFindExisting() {
        manager.buyTicket(ticket1);
        manager.buyTicket(ticket3);
        manager.buyTicket(ticket2);
        manager.deleteTicket(2);
        TicketsData[] expected = {ticket1, ticket3};
        TicketsData[] actual = repo.findAllNotSpecific();

        assertArrayEquals(expected, actual);
    }

    @Test
    void showById() {
        manager.buyTicket(ticket4);
        manager.buyTicket(ticket5);
        manager.buyTicket(ticket6);


        TicketsData expected = ticket4;
        TicketsData actual = repo.findById(4);

        assertEquals(expected,actual);
    }
    @Test
    void showByIdNonExisting() {
        manager.buyTicket(ticket4);
        manager.buyTicket(ticket5);
        manager.buyTicket(ticket6);


        TicketsData expected = null;
        TicketsData actual = repo.findById(8);

        assertEquals(expected,actual);
    }
    @Test
    void removeByIdNonExisting() {
        manager.buyTicket(ticket4);
        manager.buyTicket(ticket5);
        manager.buyTicket(ticket6);


        assertThrows(RuntimeException.class, () -> manager.deleteTicket(8));
    }
}
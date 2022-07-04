package ru.netology.manager;

import ru.netology.domain.TicketsData;
import ru.netology.repo.Repo;

public class Manager {
    private Repo repo;

    public Manager(Repo repo) {
        this.repo = repo;
    }

    public void buyTicket(TicketsData ticket) {
        repo.addTicket(ticket);
    }

    public void deleteTicket(int id) {
        repo.removeById(id);
    }

    public TicketsData[] showAll(String departure, String arrival) {

        return repo.findAll(departure, arrival);
    }

}

package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private final TicketRepository repository = new TicketRepository();
    private final TicketManager manager = new TicketManager(repository);

    private final Ticket first = new Ticket(1, 9000, "VKO", "АНА", 180);
    private final Ticket second = new Ticket(2, 7000, "KZN", "MMK", 180);
    private final Ticket third = new Ticket(3, 5800, "VKO", "АНА", 160);
    private final Ticket fourth = new Ticket(4, 3700, "SVO", "NOJ", 180);
    private final Ticket fifth = new Ticket(5, 24000, "VKO", "АНА", 120);
    private final Ticket sixth = new Ticket(6, 6900, "OHO", "UYG", 120);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldSortingSameDirection() {
        Ticket[] expected = new Ticket[]{first, third, fifth};
        Ticket[] actual = manager.searchBy("VKO", "АНА");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSingleDirection() {
        Ticket[] expected = new Ticket[]{sixth};
        Ticket[] actual = manager.searchBy("OHO", "UYG");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForNonexistentArray() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchBy("HYT", "YTR");
        assertArrayEquals(expected, actual);
    }

}
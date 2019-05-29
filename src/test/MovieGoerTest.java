package test;

import exceptions.ShowingFullException;
import exceptions.UnderAgeException;
import model.Movie;
import model.MovieGoer;
import model.Ticket;
import model.TicketKiosk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieGoerTest {

    private Movie m1, m2;
    private MovieGoer mg1, mg2;
    private Ticket t1, t2;
    private TicketKiosk tk;

    @Before
    public void setUp() {
        tk = new TicketKiosk("Scotiabank Theatre");
        mg1 = new MovieGoer("Tom Hanks", 28, tk);
        mg2 = new MovieGoer("Sarah Johnson", 17, tk);
        m1 = new Movie("Arrival", 19, 50);
        m2 = new Movie("Ratatouille", 0, 100);
        t1 = new Ticket(m1);
        t2 = new Ticket(m2);
    }

    @Test
    public void testGetters() {
        assertEquals(mg1.getName(),"Tom Hanks");
        assertEquals(mg2.getName(),"Sarah Johnson");
        assertEquals(mg1.getAge(),28);
        assertEquals(mg2.getAge(),17);
        assertEquals(mg1.getTicketKiosk(), tk);
        assertEquals(mg2.getTicketKiosk(), tk);
    }

    @Test
    public void testBuyTicketNoUnderAgeException() {
       // TODO: implement this test method where you do NOT expect the buyTicket() method to throw UnderAgeException
        try {
            System.out.println("buying legitimate ticket");
            tk.sellTicket(mg1, m1);
        } catch (ShowingFullException e) {
            //
        } catch (UnderAgeException e) {
            fail("Caught non existent under age exception");
            System.out.println(e);
        }
    }

    @Test
    public void testBuyTicketUnderAgeException() {
        // TODO: implement this test method where you DO expect the buyTicket() method to throw UnderAgeException
        try {
            tk.sellTicket(mg2, m1);
            fail("Did not catch under age exception");
        } catch (ShowingFullException e) {
            //
        } catch (UnderAgeException e) {
            System.out.println(e);
        }
    }


    @Test
    public void testBuyTicketNoShowingFullException() {
        // TODO: implement this test method where you do NOT expect the buyTicket() method to throw ShowingFullException
        try {
            m1.setCurrentSeating(45);
            System.out.println("selling ticket when seating available");
            tk.sellTicket(mg1, m1);
        } catch (UnderAgeException e) {
            //
        } catch (ShowingFullException e) {
            System.out.println(e);
            fail("Caught non existent showing full exception");
        }
    }

    @Test
    public void testBuyTicketShowingFullException() {
        // TODO: implement this test method where you DO expect the buyTicket() method to throw ShowingFullException
        try {
            m1.setCurrentSeating(50);
            System.out.println("selling ticket when no seating available");
            tk.sellTicket(mg1, m1);
            fail("missed showing full exception");
        } catch (UnderAgeException e) {
            //
        } catch (ShowingFullException e) {
            System.out.println(e);
        }
    }


}
package model;
import exceptions.ShowingFullException;
import exceptions.UnderAgeException;

import java.util.LinkedList;
import java.util.List;

public class TicketKiosk {

    private String name;
    private List<Movie> movies;

    // EFFECTS: TicketKiosk with name (name) is created
    public TicketKiosk(String name) {
        this.name = name;
        movies = new LinkedList<>();
    }

    // getters
    public String getName() { return this.name; }
    public List<Movie> getMovies() { return this.movies; }

    //EFFECTS:  adds the movie to movies, unless it is already in movies.
    //          if add is successful return true, otherwise return false.
    public boolean addMovie(Movie m) {
        boolean movieAdded = false;
        int moviesLength = movies.size();
        movies.add(m);
        if (movies.size() == moviesLength + 1) {
            movieAdded = true;
        }
        assert(movies.size() > moviesLength);
        return movieAdded;
    }

    //EFFECTS: calls MovieGoer's buyTicket method, passing m as a parameter.
    public boolean sellTicket(MovieGoer mg, Movie m) throws ShowingFullException, UnderAgeException {
        mg.buyTicket(m);
        return true;
    }


}

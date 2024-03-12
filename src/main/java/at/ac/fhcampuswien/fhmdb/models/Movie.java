package at.ac.fhcampuswien.fhmdb.models;

import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private String genre;

    public Movie(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() { return genre; }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        movies.add(new Movie("Fast and Furious", "Good Family Movie, but fast", "ACTION"));
        movies.add(new Movie("Mathe", "The upmost scary movie prob. ever!", "HORROR"));
        movies.add(new Movie("The Matrix", "Mind-bending action-packed adventure", "SCIENCE_FICTION"));
        movies.add(new Movie("Inception", "A thrilling journey through dreams within dreams", "SCIENCE_FICTION"));
        movies.add(new Movie("The Shawshank Redemption", "A timeless tale of hope and redemption", "DRAMA"));
        movies.add(new Movie("Pulp Fiction", "Quirky characters and intertwining storylines", "CRIME"));
        movies.add(new Movie("The Dark Knight", "Epic superhero saga with a dark twist", "ACTION"));
        movies.add(new Movie("The Godfather", "A mafia masterpiece with unforgettable performances", "CRIME"));
        movies.add(new Movie("Titanic", "Epic romance set against the backdrop of a historic tragedy", "ROMANCE"));
        movies.add(new Movie("Jurassic Park", "Thrilling adventure with prehistoric beasts", "ADVENTURE"));
        movies.add(new Movie("Avatar", "Visually stunning sci-fi epic with a powerful message", "SCIENCE_FICTION"));
        movies.add(new Movie("Forrest Gump", "Heartwarming journey through decades of American history", "DRAMA"));
        movies.add(new Movie("The Lion King", "A timeless tale of a young lion's journey to become king", "ANIMATION"));
        return movies;
    }
}

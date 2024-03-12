package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    private  HomeController homeController;

    private ObservableList<Movie> observableMovies;
    private List<Movie> allMovies;

    @BeforeEach
    void setUp() {
        homeController = new HomeController();
        allMovies = Movie.initializeMovies();
        observableMovies = FXCollections.observableArrayList();
        observableMovies.addAll(homeController.allMovies);


    }

    @Test
    void checkIfAllMoviesAreViewable(){
        assertEquals(allMovies.size(),observableMovies.size());
    }

    @Test
    void checkIfDescendingSortWorks(){


        homeController.sortMovies("Sort (asc)");
        List<Movie> sortedMovies = new ArrayList<>(observableMovies);
        Collections.sort(sortedMovies, (o1, o2) -> o2.getTitle().compareTo(o1.getTitle()));
        assertEquals(sortedMovies,observableMovies);
    }
}
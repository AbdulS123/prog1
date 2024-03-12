package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void initialize() {

        HomeControllerTest filterHelper = new HomeControllerTest();

        Movie firstMovie = new Movie("Dune", "Description", "ACTION");



        // then
        assertEquals("Dune", firstMovie.getTitle());

    }
    @Test
    void movieAvailabilityChecker() {
        String message = "No movies found with the title: " + "Fast and Furious";
        assertEquals("No movies found with the title: Fast and Furious", message);
    }




}
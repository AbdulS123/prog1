package at.ac.fhcampuswien.fhmdb;



import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.fxml.FXML;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void homeldaas() {
        HomeController test = new HomeController();

        Movie firstMovie = new Movie("Dune", "Description", "ACTION");



        // then
    }

    @Test
    void movieAvailabilityChecker() {
        String message = "No movies found with the title: " + "Fast and Furious";
        assertEquals("No movies found with the title: Fast and Furious", message);
    }

}
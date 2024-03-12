package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable{
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;


    public Label errorMessageLb;

    @FXML
    void searchBtnClick(ActionEvent event) {
        errorMessageLb.setVisible(false);

        if (!searchField.getText().isEmpty()) {
            observableMovies.clear();
            for (int i = 0; i < allMovies.size(); i++) {
                if (allMovies.get(i).getTitle().contains(searchField.getText())) {
                    observableMovies.add(allMovies.get(i));
                }
            }
            if(observableMovies.isEmpty()){
                movieAvailabilityChecker("No movies found with the title: " + searchField.getText() );
                searchField.clear();
            }
        } else if (genreComboBox.getValue() != null) {
            observableMovies.clear();
            for (int i = 0; i < allMovies.size(); i++) {
                if (allMovies.get(i).getGenre().equals(genreComboBox.getValue())) {
                    observableMovies.add(allMovies.get(i));
                }
            }
            if(observableMovies.isEmpty()){
                movieAvailabilityChecker("No movies found with the genre: " + genreComboBox.getValue());
                genreComboBox.setValue(null);
            }
        } else {
            observableMovies.clear();
            observableMovies.addAll(allMovies);
            movieListView.setItems(observableMovies);   // set data of observable list to list view
            movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        }

    }
    public List<Movie> allMovies = Movie.initializeMovies();

    final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes



public void movieAvailabilityChecker(String errorMessage){
    errorMessageLb.setText(errorMessage);
    errorMessageLb.setVisible(true);

}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.setItems(FXCollections.observableArrayList("ACTION", "ADVENTURE", "ANIMATION", "BIOPIC", "COMEDY", "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR", "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR", "WESTERN"));




        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            errorMessageLb.setVisible(false);
            if(sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                sortBtn.setText("Sort (desc)");
                Collections.sort(observableMovies, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                movieListView.setItems(observableMovies);
            } else {
                // TODO sort observableMovies descending
                sortBtn.setText("Sort (asc)");
                Collections.sort(observableMovies, (o1, o2) -> o2.getTitle().compareTo(o1.getTitle()));
                movieListView.setItems(observableMovies);
            }

        });


    }



}
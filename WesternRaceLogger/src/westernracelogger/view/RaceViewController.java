package westernracelogger.view;

import java.sql.Timestamp;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import westernracelogger.WesternRaceLogger;
import westernracelogger.model.Runner;

public class RaceViewController {
    @FXML
    private TableView<Runner> personTable;
    @FXML
    private TableColumn<Runner, String> idColumn;
    
    @FXML
    private TableColumn<Runner, String> nameColumn;
    
    @FXML
    private TableColumn<Runner, String> genderColumn;
    
    @FXML
    private TableColumn<Runner, Integer> ageColumn;
    
    @FXML
    private TableColumn<Runner, Timestamp> inTimeColumn;
    
    @FXML
    private TableColumn<Runner, Integer> inPlaceColumn;
    
    @FXML
    private TableColumn<Runner, Timestamp> outTimeColumn;
    
    @FXML
    private TableColumn<Runner, Integer> outPlaceColumn;
   
    // Reference to the main application.
    private WesternRaceLogger westernRaceLogger;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public RaceViewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	idColumn.setCellValueFactory(cellData -> cellData.getValue().runnerIDProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        inTimeColumn.setCellValueFactory(cellData -> cellData.getValue().inTimeProperty());
        inPlaceColumn.setCellValueFactory(cellData -> cellData.getValue().inPlaceProperty().asObject());
        outTimeColumn.setCellValueFactory(cellData -> cellData.getValue().outTimeProperty());
        outPlaceColumn.setCellValueFactory(cellData -> cellData.getValue().outPlaceProperty().asObject());
        
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(WesternRaceLogger westernRaceLogger) {
        this.westernRaceLogger = westernRaceLogger;

        // Add observable list data to the table
        personTable.setItems(westernRaceLogger.getRunnerData());
    }
}
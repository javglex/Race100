package westernracelogger.view;

import westernracelogger.controller.WesternRaceLogger;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import westernracelogger.model.Runner;

public class RaceView {

	/*
	@FXML
    private TableView<Runner> runnerTable;
	
	@FXML
    private TableColumn<Runner, String> runnerIdColumn;
	
	@FXML
	private TableColumn<Runner, String> firstNameColumn;
	
	@FXML
	private TableColumn<Runner, String> lastNameColumn;
	
	@FXML
	private TableColumn<Runner, String> genderColumn;
	
	@FXML
	private TableColumn<Runner, String> ageColumn;
	
	private WesternRaceLogger wRController;
    
	public RaceView(BorderPane rootLayout) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(WesternRaceLogger.class.getResource("/westernracelogger/view/RaceView.fxml"));
            AnchorPane RaceView = (AnchorPane) loader.load();

            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(RaceView);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@FXML
	private void initialize() {
	}
	
	@FXML
	public void setInfo(ObservableList<Runner> runnerData){
		runnerTable.setItems(runnerData);
	}
	
	public TableView<Runner> getTableView(){
		return runnerTable;
	}
	public void test(){
		System.out.println("asdf");
	}*/
	
}

package westernracelogger;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import westernracelogger.model.Runner;
import westernracelogger.model.SQLDriver;
//import westernracelogger.model.SQLDriver;
//import westernracelogger.view.RaceViewController;
import westernracelogger.view.RaceViewController;

public class WesternRaceLogger extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Runner> runnerData = FXCollections.observableArrayList();
    
    
    public WesternRaceLogger(){
    	runnerData.add(new Runner("123", "Abem Adams", "Male", 18));
		runnerData.add(new Runner("F33", "Beatrice Burnell", "Female", 18));
		runnerData.add(new Runner("M33", "Conan Cox", "Male", 18));
		runnerData.add(new Runner("32", "Denise Dunno", "Female", 18));
		runnerData.add(new Runner("231", "Evan Elephant?", "Male", 18));
		runnerData.add(new Runner("66", "Francis Ffsd", "Male", 18));
    }

    public ObservableList<Runner> getRunnerData() {
        return runnerData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Wser App");

        initRootLayout();
        fileChooserPopup();
        showRaceView();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(WesternRaceLogger.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showRaceView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(WesternRaceLogger.class.getResource("view/RaceView.fxml"));
            AnchorPane raceView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(raceView);
            
            RaceViewController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void fileChooserPopup() {
		FileChooser fileChooser = new FileChooser();
    	File selectedFile = fileChooser.showOpenDialog(null);

    	if (selectedFile != null) {

    		 System.out.println("File selected: " + selectedFile.getName());
    		 SQLDriver.FileIntoList(selectedFile.getAbsolutePath());
    	}
    	else {
    		 System.out.println("File selection cancelled.");
    	}
	}

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
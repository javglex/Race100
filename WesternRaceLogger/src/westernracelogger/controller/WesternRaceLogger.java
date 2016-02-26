package westernracelogger.controller;

import java.io.IOException;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import westernracelogger.model.Runner;

public class WesternRaceLogger extends Application {

	
	private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Runner> runnerData = FXCollections.observableArrayList();

    
    
	@Override
    public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("WSER application");
		
		initRootLayout();
		showRaceView();
    }
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(WesternRaceLogger.class.getResource("/westernracelogger/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            //primaryStage.setResizable(false);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showRaceView() {
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
	
	public static void main(String[] args) {
        launch(args);
    }

}

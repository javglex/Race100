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
import westernracelogger.view.RaceView;

public class WesternRaceLogger extends Application {

	
	private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Runner> runnerData = FXCollections.observableArrayList();

    
    
	@Override
    public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("WSER application");
		
		runnerData.add(new Runner("123", "Abem Adams", "Male", 18));
		runnerData.add(new Runner("F33", "Beatrice Burnell", "Female", 18));
		runnerData.add(new Runner("M33", "Conan Cox", "Male", 18));
		runnerData.add(new Runner("32", "Denise Dunno", "Female", 18));
		runnerData.add(new Runner("231", "Evan Elephant?", "Male", 18));
		runnerData.add(new Runner("66", "Francis Ffsd", "Male", 18));
		
		
		initRootLayout();
		
		RaceView rv = new RaceView(rootLayout);
		
		rv.test();
		
		rv.setInfo(runnerData);
		//showRaceView();
    }
	
	public ObservableList<Runner> getRunnerData() {
        return runnerData;
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
	
	/*
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
    }*/
	
	public static void main(String[] args) {
        launch(args);
    }

}

package westernracelogger.controller;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

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
		
		//RaceView rv = new RaceView(rootLayout);
		
		//rv.test();
		
		//rv.setInfo(runnerData);
		showRaceView();
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

	
	public void showRaceView() {
        try {
        	fileChooserPopup();

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
		SQLDriver.initDriver();
		launch(args);
    }

}

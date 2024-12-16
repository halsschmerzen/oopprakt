package main;

import gui.TeppichhandelControl;
import gui.TeppichhandelView;
import guiBodenbelaege.BodenbelaegeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeppichhandelControl(primaryStage);
		
		Stage zweitesFenster = new Stage();
		new BodenbelaegeControl(zweitesFenster);
	}	
	
	
	
	public static void main(String[] args){
		launch(args);
	}
}

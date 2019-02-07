package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow() {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));
		
		try {
			AnchorPane pane = loader.load();
			
			primaryStage.setMinWidth(1000.0);
			primaryStage.setMaxHeight(600.0);
			
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("Błąd tworzenia okna!");
			//e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

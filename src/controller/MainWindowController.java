package controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
	private Main main;
	private Stage primaryStage;
	
	private ObservableList<Person> personList = FXCollections.observableArrayList();
	
	
	@FXML private Button loadButton;
	@FXML private Button saveButton;
	@FXML private Button addButton;
	@FXML private Button raportButton;
	
	@FXML private TableView<Person> tableView;
	@FXML private TableColumn<Person, String> firstNameColumn;
	@FXML private TableColumn<Person, String> lastNameColumn;
	@FXML private TableColumn<Person, Integer> roomNumberColumn;
	
	@FXML private TextField firstNameTextField;
	@FXML private TextField lastNameTextField;
	@FXML private TextField roomNumberTextField;
	@FXML private TextField startHourTextField;
	@FXML private TextField stopHourTextField;
	
	
	public void initialize() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		
		//setList();
//		tableView.setItems(personList);
//		
//		tableView.getSelectionModel().selectedItemProperty().addListener((ov,oldVal,newVal) -> {
//			System.out.println(newVal.getFirstName() + " | " + newVal.getLastName() + " | " + newVal.getRoomNumber());
//			
//			firstNameTextField.setText(newVal.getFirstName());
//			lastNameTextField.setText(newVal.getLastName());
//			roomNumberTextField.setText(newVal.getRoomNumber().toString());
//			startHourTextField.setText(newVal.getStartHour().toString());
//			stopHourTextField.setText(newVal.getStopHour().toString());
//		}); 
	}
	
	//====== load button =======================================
	@FXML public void loadButton() {
		
		personList.clear();
		
		//ArrayList<Person> persons = new ArrayList<>();
		String firstName;
		String lastName;
		Integer roomNumber;
		Integer startHour;
		Integer stopHour;
		
		try(Scanner scan = new Scanner(Paths.get("/home/persons.txt"))) {
			while(scan.hasNext()) {
				firstName = scan.next();
				lastName = scan.next();
				roomNumber = scan.nextInt();
				startHour = scan.nextInt();
				stopHour = scan.nextInt();
				
				personList.add(new Person(firstName, lastName, roomNumber, startHour, stopHour));
			}
			
			tableView.setItems(personList);
			
			tableView.getSelectionModel().selectedItemProperty().addListener((ov,oldVal,newVal) -> {
				System.out.println(newVal.getFirstName() + " | " + newVal.getLastName() + " | " + newVal.getRoomNumber());
				
				firstNameTextField.setText(newVal.getFirstName());
				lastNameTextField.setText(newVal.getLastName());
				roomNumberTextField.setText(newVal.getRoomNumber().toString());
				startHourTextField.setText(newVal.getStartHour().toString());
				stopHourTextField.setText(newVal.getStopHour().toString());
			}); 
			
			
		} catch (IOException e) {
			System.out.println("Błąd wczytywania pliku!");
			//e.printStackTrace();
		}
		
		//loadButton.setDisable(true);
	}
	
	//====== save button =======================================
	@FXML public void saveButton() {
		System.out.println("save");
	}
	
	//====== add button =======================================
	@FXML public void addButton() {
		System.out.println("add");
	}
	
	//====== raport button =======================================
	@FXML public void raportButton() {
		System.out.println("raport");
	}
	
//	private void setList() {
//		personList.add(new Person("Jan", "Nowak", 10, 8, 16));
//		personList.add(new Person("Tom", "Kowalski", 25, 8, 16));
//	}
	
	
	public void setMain(Main main) {
		this.main = main;
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}

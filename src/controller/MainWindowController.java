package controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Person;

public class MainWindowController {
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
	
	@FXML private Pane room1;
	@FXML private Pane room2;
	@FXML private Pane room3;
	@FXML private Pane room4;
	@FXML private Pane room5;
	@FXML private Pane room6;
	@FXML private Pane room7;
	@FXML private Pane room8;
	@FXML private Pane room9;
	@FXML private Pane room10;
	
	
	public void initialize() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber")); 
		
		defaultRoomDisable();
	}
	
	private void printTableData() {
		tableView.setItems(personList);
		
		tableView.getSelectionModel().selectedItemProperty().addListener((ov,oldVal,newVal) -> {
			System.out.println(newVal.getFirstName() + " | " + newVal.getLastName() + " | " + newVal.getRoomNumber());
			
			selectedRoom(newVal.getRoomNumber());
			
			firstNameTextField.setText(newVal.getFirstName());
			lastNameTextField.setText(newVal.getLastName());
			roomNumberTextField.setText(newVal.getRoomNumber().toString());
			startHourTextField.setText(newVal.getStartHour().toString());
			stopHourTextField.setText(newVal.getStopHour().toString());
		}); 
	}
	
	//====== load button =======================================
	@FXML public void loadButton() {
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
			
			printTableData();
			
			loadButton.setDisable(true);
		} catch (Exception e) {
			System.out.println("Błąd wczytywania pliku!");
			//e.printStackTrace();
		}
	}
	
	//====== save button =======================================
	@FXML public void saveButton() {
		char separator = ' ';
		
		try(PrintWriter out = new PrintWriter("/home/persons.txt")) {
			
			for(Person p : personList) {
				System.out.println(p);
				
				out.print(p.getFirstName() + separator);
				out.print(p.getLastName() + separator);
				out.print(p.getRoomNumber().toString() + separator);
				out.print(p.getStartHour().toString() + separator);
				out.print(p.getStopHour().toString() + System.lineSeparator());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Błąd zapisu do pliku!");
			//e.printStackTrace();
		}
	}
	
	//====== add button =======================================
	@FXML public void addButton() {
		try {
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			Integer roomNumber = Integer.parseInt(roomNumberTextField.getText());
			Integer startHour = Integer.parseInt(startHourTextField.getText());
			Integer stopHour = Integer.parseInt(stopHourTextField.getText());
			
			personList.add(new Person(firstName, lastName, roomNumber, startHour, stopHour));
			
			printTableData();
		} catch (Exception e) {
			System.out.println("Wszystkie pola muszą być prawidłowo wypełnione!");
			//e.printStackTrace();
		}
	}
	
	//====== raport button =======================================
	@FXML public void raportButton() {
		ArrayList<Person> persons = new ArrayList<>();
		for(Person p : personList) {
			persons.add(p);
		}
		
		char separator = ' ';
		
		try(PrintWriter out = new PrintWriter("/home/raport.txt")) {
			Collections.sort(persons);
			
			for(Person p : persons) {
				System.out.println(p);
				
				out.print(p.getFirstName() + separator);
				out.print(p.getLastName() + separator);
				out.print(p.getRoomNumber().toString() + separator);
				out.print(p.getStartHour().toString() + separator);
				out.print(p.getStopHour().toString() + System.lineSeparator());
			}
			
		} catch (Exception e) {
			System.out.println("Błąd zapisu do pliku!");
			//e.printStackTrace();
		}
	}
	
	//====== room selected ===================
		private void selectedRoom(Integer roomNumber) {
			defaultRoomDisable();
			
			switch (roomNumber) {
			case 1:
				room1.setDisable(false);
				break;
			case 2:
				room2.setDisable(false);
				break;
			case 3:
				room3.setDisable(false);
				break;
			case 4:
				room4.setDisable(false);
				break;
			case 5:
				room5.setDisable(false);
				break;
			case 6:
				room6.setDisable(false);
				break;
			case 7:
				room7.setDisable(false);
				break;
			case 8:
				room8.setDisable(false);
				break;
			case 9:
				room9.setDisable(false);
				break;
			case 10:
				room10.setDisable(false);
				break;

			default:
				break;
			}
		}
		
		private void defaultRoomDisable() {
			room1.setDisable(true);
			room2.setDisable(true);
			room3.setDisable(true);
			room4.setDisable(true);
			room5.setDisable(true);
			room6.setDisable(true);
			room7.setDisable(true);
			room8.setDisable(true);
			room9.setDisable(true);
			room10.setDisable(true);
		}
	
}

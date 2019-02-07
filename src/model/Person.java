package model;

public class Person implements Comparable<Person>{
	private String firstName;
	private String lastName;
	private Integer roomNumber;
	private Integer startHour;
	private Integer stopHour;
	private Integer workingHours;
	
	public Person(String firstName, String lastName, Integer roomNumber, Integer startHour, Integer stopHour) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomNumber = roomNumber;
		this.startHour = startHour;
		this.stopHour = stopHour;
		workingHours = stopHour - startHour;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getStartHour() {
		return startHour;
	}
	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getStopHour() {
		return stopHour;
	}
	public void setStopHour(Integer stopHour) {
		this.stopHour = stopHour;
	}
	
	public Integer getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(Integer workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", roomNumber=" + roomNumber
				+ ", startHour=" + startHour + ", stopHour=" + stopHour + ", workingHours=" + workingHours + "]";
	}

	@Override
	public int compareTo(Person person) {
		return Integer.compare(workingHours, person.workingHours);
	}
}

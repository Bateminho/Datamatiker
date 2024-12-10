package model;

public class Customer {
	private String lastName;
	private String firstName;
	private int age;
	
	public Customer(String firstName, String lastName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	


	public int getAge() {
		return age;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	@Override
    public String toString(){
		return firstName + " " + lastName + " " + age;
	}
}

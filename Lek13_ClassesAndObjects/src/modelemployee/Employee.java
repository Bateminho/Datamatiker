package modelemployee;

import java.nio.file.FileStore;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String firstName = "John";
	private String lastName = "Doe";
	private boolean trainee = false;
	private int age = 0;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String _firstName, String _lastName, int inputAge) {
		firstName = _firstName;
		lastName = _lastName;
		age = inputAge;
		trainee = true;

	}
	public Employee() {

	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setFullName(String _firstName, String _lastName) {
		firstName = _firstName; lastName = _lastName;
	}

	public void setFirstName(String _firstName) { firstName = _firstName; }

	public void setLastName(String _lastName) { lastName = _lastName; }


	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }

	public void setAge(int inputAge) { age = inputAge; }

	public int getAge() { return age; }

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void birthday() {
		age++;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Fornavn: " + firstName);
		System.out.println("Efternavn: " + lastName);
		System.out.println("Age " + age);
		System.out.println("Trainee " + trainee);
		System.out.println();
	}



	/*
	 * Returnerer en kort tekst repræsentation af objektet
	 */
//	public String toString(){
//		return name;
//	}
}

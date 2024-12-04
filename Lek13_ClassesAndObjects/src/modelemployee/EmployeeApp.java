package modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 55);
		e1.printEmployee();
		e1.setFullName("Viggo" , " ");
		e1.setAge(45);
		e1.printEmployee();

		System.out.println(e1);
		System.out.println("Navn: " + e1.getFullName());

		Employee e2 = new Employee();
		System.out.println(e2);
		e2.printEmployee();
		System.out.println("Navn: " + e2.getFullName());

		Employee e3 = new Employee("Dorthe", "Jensen", 32);
		e3.printEmployee();

		e3.birthday();
		System.out.println(e3.getFullName() + " har haft fødselsdag og er nu " + e3.getAge() + " år gammel!");

		Employee e4 = new Employee("Hanne", "Sommer", 32);
		e4.printEmployee();

	}

}

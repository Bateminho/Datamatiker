package opgave2SelectionSort;

public class Person {
	private final String name;
	private final String title;
	private final boolean senior;

	public Person(String title, String name, boolean senior) {
		this.name = name;
		this.title = title;
		this.senior = senior;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public boolean getSenior() {
		return this.senior;
	}

	@Override
	public String toString() {

		String s = title + " " + name;
		if (senior) s = s + " (senior) ";
		return s;
	}

}

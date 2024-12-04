package opgave4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	// // komposition: --> 0..* Swimmer
	private final ArrayList<Swimmer> swimmers = new ArrayList<>();
	
	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public char getLevel() {
		return this.level;
	}
	
	public void setLevel(char niveau) {
		this.level = niveau;
	}
	
	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}
	
	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}
	
	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}

	public Swimmer createSwimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
		Swimmer newSwimmer = new Swimmer(name, yearGroup, lapTimes, club);
		swimmers.add(newSwimmer);
		return newSwimmer;
	}


	public void addSwimmer(Swimmer swimmer) {
		if (!swimmers.contains(swimmer)) {
			swimmers.add(swimmer);

		}
	}

	public void removeSwimmer(Swimmer swimmer) {
        if(swimmers.contains(swimmer))
		swimmers.remove(swimmer);
	}

	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}
}

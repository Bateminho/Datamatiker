package model;

import java.util.ArrayList;

public class Person {
    private String name;
    private int wageMonth;

    private ArrayList<String> jobs;

    public Person(String name, int wageMonth) {
        this.name = name;
        this.wageMonth = wageMonth;
        jobs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWageMonth() {
        return wageMonth;
    }

    public void setWageMonth(int wageMonth) {
        this.wageMonth = wageMonth;
    }

    public void addJob(String job) {
        jobs.add(job);
    }

    public void udskrivJobs() {
        for (int i = 0; i <jobs.size(); i++) {
            System.out.println(jobs.get(i));
        }
    }
    public void udskrivJobs2() {
        for (String s: jobs) {
            System.out.println(s);
        }
    }

    public String toString(){
        return name;
    }
}

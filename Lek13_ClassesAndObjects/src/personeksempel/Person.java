package personeksempel;

public class Person {

    private String name;
    private String address;
    private double monthlySalary;
    private int companies;
    private boolean newCompany = false;

    public Person(String _name) {
        name = _name;
    }

    public Person(String _name, String _address, double _monthlySalary, int _companies, boolean _newCompany) {
        name = (_name != null) ? _name : "John Doe";
        address = (_address != null ) ? _address : "Unknown";
        monthlySalary = _monthlySalary;
        companies = _companies;
        newCompany = _newCompany;

    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName(){ return name; }

    public void setAddress(String _address) {
        if (_address == null || _address.isEmpty()) {
            address = "Unknown"; // Default værdi, hvis der ikke er angivet noget
        } else {
            address = _address;
        }
    }

    public String getAddress() { return address; }

    public void setMonthlySalary(double _monthlySalary) {
        monthlySalary = (_monthlySalary == 0) ? 0.0 : _monthlySalary;

    }

    public double yearlySalary() {
         return (monthlySalary * 12) * 1.025;
    }

    public double getMonthlySalary() {return monthlySalary; }

    public void setAmountCompanies(int _companies) {
        companies = _companies;
    }

    public int getAmountCompanies() {return companies; }

    public void setNewCompany(boolean _newCompany) {
        newCompany = _newCompany;
    }

    public boolean getNewCompany() { return newCompany; }

    public void printPerson() {
        System.out.println("*******************");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Monthly Salary $" + monthlySalary);
        System.out.println("Yearly salary + vacation pay $" + yearlySalary());
        System.out.println("Amount of companies worked for: " + companies);
        System.out.println("Started at new company: " + newCompany);
        System.out.println();
    }



}

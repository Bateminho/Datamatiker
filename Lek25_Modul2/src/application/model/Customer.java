package application.model;

public class Customer {
    private String name;

    // link to company class (--> 0..1)
    private Company company;

    public Customer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() { return name; }

    }

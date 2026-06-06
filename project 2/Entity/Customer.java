package Entity;

public class Customer extends Person {
    private String location;

    public Customer(String Id, String Name, String location) {
        super(Id, Name);
        this.location = location;
    }

    public Customer() {
        super();
    }

    public void setLocation(String location) { this.location = location; }
    public String getLocation() { return location; }

    @Override
    public void showDetails() {
        System.out.println("Customer ID: " + Id);
        System.out.println("Name: " + Name);
        System.out.println("Location: " + location);
    }

    @Override
    public String getDetails() {
        return "Customer ID: " + Id + ", Name: " + Name + ", Location: " + location;
    }
}
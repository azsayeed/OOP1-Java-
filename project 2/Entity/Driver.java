package Entity;

public class Driver extends Person {
    private String hiringDetails;

    public Driver(String Id, String Name, String hiringDetails) {
        super(Id, Name);
        this.hiringDetails = hiringDetails;
    }

    @Override
    public void showDetails() {
        System.out.println("Driver ID: " + Id + " | Name: " + Name + " | Info: " + hiringDetails);
    }

    @Override
    public String getDetails() {
        return "Driver ID: " + Id + ", Name: " + Name + ", Hiring: " + hiringDetails;
    }
}
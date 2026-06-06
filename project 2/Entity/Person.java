package Entity;

public abstract class Person {
    protected String Id;
    protected String Name;

    public Person(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }
    public Person() {}
    public void setName(String Name) {
		this.Name = Name;
	}
    public void setId(String Id) {
		this.Id = Id; 
	}
    public String getName() {
		return Name; 
	}
    public String getId() {
		return Id; 
	}

    public abstract void showDetails();
    public abstract String getDetails();
}
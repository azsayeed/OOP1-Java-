package Entity;

public class Vehicle {
    private String vehicleName;
    private String numberPlate;
    private String vehicleType;
    private double priceValue;

    public Vehicle(String vehicleName, String numberPlate, String vehicleType, double priceValue) {
        this.vehicleName = vehicleName;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        this.priceValue = priceValue;
    }

    public String getVehicleName() { 
		return vehicleName;
	}
    public String getNumberPlate() {
		return numberPlate; 
	}
    public double getPriceValue() {
		return priceValue;
	}

    public void showDetails() {
        System.out.println("Vehicle: " + vehicleName + " [" + numberPlate + "] Type: " + vehicleType);
    }
}
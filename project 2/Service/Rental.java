package Service;

import Entity.*;
import Interface.*;
import File.FileIO;

public class Rental implements IRentalService {
    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private Driver driver;
    private String paymentType;
    private String paymentMethod;

    private static Rental[] rentals = new Rental[100];
    private static int rentalCount = 0;

    public Rental(String rentalId, Vehicle vehicle, Customer customer,
                  Driver driver, String paymentType, String paymentMethod) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.driver = driver;
        this.paymentType = paymentType;
        this.paymentMethod = paymentMethod;
    }

    public static void updateFile() {
        String allData = "--- ALL RENTAL RECORDS ---\n";
        for (int i = 0; i < rentalCount; i++) {
            allData += rentals[i].getAllDetails(1) + "\n--------------------\n";
        }
        FileIO.saveInFile(allData);
    }

    public static void addRental(Rental r) {
        if (rentalCount < 100) {
            rentals[rentalCount++] = r;
            updateFile();
        }
    }

    public static void editRental(String id, Rental updated) {
        for (int i = 0; i < rentalCount; i++) {
            if (rentals[i].rentalId.equals(id)) {
                rentals[i] = updated;
                updateFile();
                return;
            }
        }
    }

    public static void removeRental(String id) {
        for (int i = 0; i < rentalCount; i++) {
            if (rentals[i].rentalId.equals(id)) {
                for (int j = i; j < rentalCount - 1; j++) {
                    rentals[j] = rentals[j + 1];
                }
                rentals[--rentalCount] = null;
                updateFile();
                return;
            }
        }
    }

    public String getAllDetails(int days) {
        double total = calculatePrice(customer.getLocation(), days);
        return "Rental ID: " + rentalId + "\n" +
               customer.getDetails() + "\n" +
               "Vehicle: " + vehicle.getVehicleName() + "\n" +
               (driver != null ? "Driver: " + driver.getName() : "No Driver") + "\n" +
               "Price: " + total + " BDT";
    }

    public static Rental[] getRentals() { 
		return rentals; 
	}
    public static int getCount() { 
		return rentalCount;
	}

    @Override
    public double calculatePrice(String location, int days) {
        double base = location.equalsIgnoreCase("Dhaka") ? 1000 : 4000;
        return (base * days) + vehicle.getPriceValue();
    }

    @Override public String paymentStatus() { 
		return paymentType; 
	}
    public void showDetails() {
		System.out.println(getAllDetails(1)); 
	}
}
package Interface;

public interface IRentalService {
    double calculatePrice(String location, int days);
    String paymentStatus();
}
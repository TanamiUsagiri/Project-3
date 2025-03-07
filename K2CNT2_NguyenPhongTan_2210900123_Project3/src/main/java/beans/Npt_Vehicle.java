package beans;

public class Npt_Vehicle {
    private int vehicleId;
    private String brand;
    private String model;
    private double price;
    private int year;
    private String status;

    public Npt_Vehicle(int vehicleId, String brand, String model, double price, int year, String status) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
        this.status = status;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }
}

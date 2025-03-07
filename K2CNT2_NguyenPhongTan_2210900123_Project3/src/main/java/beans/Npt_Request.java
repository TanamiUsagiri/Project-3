package beans;

import java.sql.Timestamp;

public class Npt_Request {
    private int requestId;
    private int userId;
    private int vehicleId;
    private String message;
    private Timestamp createdAt;

    // Constructor
    public Npt_Request(int requestId, int userId, int vehicleId, String message, Timestamp createdAt) {
        this.requestId = requestId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.message = message;
        this.createdAt = createdAt;
    }

    // Constructor
    public Npt_Request(int requestId, int userId, String message) {
        this.requestId = requestId;
        this.userId = userId;
        this.message = message;
    }

    // Getters và Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

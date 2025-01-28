package edu.neu.csye7374;

public abstract class Stock implements Tradable {
    private String id;
    private double price;
    private String description;
    private String currentBid;

    public Stock(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            if (currentBid == null || Double.parseDouble(currentBid) < bidValue) {
                currentBid = bid;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Stock ID: " + id + "\n" +
                "Price: $" + String.format("%.2f", price) + "\n" +
                "Description: " + description + "\n" +
                "Current Bid: $" + (currentBid != null ? currentBid : "No bids yet");
    }
}
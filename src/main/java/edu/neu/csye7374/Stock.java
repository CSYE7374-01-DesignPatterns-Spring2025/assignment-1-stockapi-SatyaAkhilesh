package edu.neu.csye7374;

public abstract class Stock implements Tradable {
    private String id;
    private double price;
    private String description;

    public Stock(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("\nStock: %-10s | Price: $%.2f\n%s", id, price, "-".repeat(45));
    }

    public String getSummary() {
        return String.format("Stock Summary → [ Name: %s | Price: $%.2f | Sector: %s | Metric: %.2f%% ]",
                id, price, description, (double) getMetric());
    }
}
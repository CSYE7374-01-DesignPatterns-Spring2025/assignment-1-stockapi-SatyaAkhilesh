package edu.neu.csye7374;

public class AmazonStock extends Stock {
    private double highestBid = 0.0;

    public AmazonStock() {
        super("AMZN", 3200.50, "E-Commerce & Cloud");
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            highestBid = Math.max(highestBid, bidValue);
            setPrice(getPrice() + 0.05 * (highestBid - getPrice()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public int getMetric() {
        return (int) ((highestBid - getPrice()) / getPrice() * 100);
    }
}
package edu.neu.csye7374;

public class GoogleStock extends Stock {
    private double highestBid = 0.0;

    public GoogleStock() {
        super("GOOGL", 2800.00, "Google LLC");
    }

    @Override
    public void setBid(String bid) {
        super.setBid(bid);
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
package edu.neu.csye7374;

public class TeslaStock extends Stock {
    private double highestBid = 0.0;

    public TeslaStock() {
        super("TSLA", 700.00, "Tesla Inc.");
    }

    @Override
    public void setBid(String bid) {
        super.setBid(bid);
        try {
            double bidValue = Double.parseDouble(bid);
            highestBid = Math.max(highestBid, bidValue);
            setPrice(getPrice() + 0.1 * (highestBid - getPrice()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public int getMetric() {
        return (int) ((highestBid - getPrice()) / getPrice() * 100);
    }
}
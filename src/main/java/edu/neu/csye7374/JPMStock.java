package edu.neu.csye7374;

public class JPMStock extends Stock {
    private double highestBid = 0.0;

    public JPMStock() {
        super("JPM", 160.00, "JP Morgan Chase & Co.");
    }

    @Override
    public void setBid(String bid) {
        super.setBid(bid);
        try {
            double bidValue = Double.parseDouble(bid);
            highestBid = Math.max(highestBid, bidValue);
            setPrice(getPrice() + 0.05 * (highestBid - getPrice())); // Adjust price by 5%.
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public int getMetric() {
        return (int) ((highestBid - getPrice()) / getPrice() * 100);
    }
}
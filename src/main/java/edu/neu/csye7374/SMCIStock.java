package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class SMCIStock extends Stock {
    private List<Double> bids = new ArrayList<>();

    public SMCIStock() {
        super("SMCI", 110.00, "Super Micro Computers Inc.");
    }

    @Override
    public void setBid(String bid) {
        super.setBid(bid);
        try {
            double bidValue = Double.parseDouble(bid);
            bids.add(bidValue);
            double averageBid = bids.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            setPrice(getPrice() + 0.05 * (averageBid - getPrice()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public int getMetric() {
        double averageBid = bids.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        return (int) ((averageBid - getPrice()) / getPrice() * 100);
    }
}
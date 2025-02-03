package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Tradable> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Tradable stock) {
        stocks.add(stock);
    }

    public void showAllStocks() {
        System.out.println("\nFinal Stock Market Overview:");
        for (Tradable stock : stocks) {
            System.out.println(((Stock) stock).getSummary());
        }
    }

    public static void demo() {
        StockMarket market = StockMarket.getInstance();

        AmazonStock amazon = new AmazonStock();
        GoogleStock google = new GoogleStock();
        TeslaStock tesla = new TeslaStock();
        SMCIStock smci = new SMCIStock();
        JPMStock jpm = new JPMStock();

        market.addStock(amazon);
        market.addStock(google);
        market.addStock(tesla);
        market.addStock(smci);
        market.addStock(jpm);

        // Run bidding simulation for each stock
        market.simulateStock(amazon, new String[]{"3300", "3400", "3500", "3600", "3700", "3800"});
        market.simulateStock(google, new String[]{"2900", "2950", "3000", "3050", "3100", "3150"});
        market.simulateStock(tesla, new String[]{"750", "760", "770", "780", "790", "800"});
        market.simulateStock(smci, new String[]{"120", "130", "140", "150", "160", "170"});
        market.simulateStock(jpm, new String[]{"165", "170", "175", "180", "185", "190"});

        System.out.println("\nFinal Stock Summary:");
        market.showAllStocks();
    }

    private void simulateStock(Stock stock, String[] bids) {
        System.out.println("\nStock: " + stock.getId() + "  (Starting Price: $" + stock.getPrice() + ")");
        System.out.println("--------------------------------------------------");

        for (String bid : bids) {
            stock.setBid(bid);
            System.out.printf("BID: $%-8s → New Price: $%-8.2f (Metric: %.2f%%)\n", bid, stock.getPrice(), (double) stock.getMetric());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Final Price: $%-8.2f | Final Metric: %.2f%%\n", stock.getPrice(), (double) stock.getMetric());
    }
}
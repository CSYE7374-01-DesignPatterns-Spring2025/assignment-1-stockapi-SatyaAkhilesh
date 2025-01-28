package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Tradable> stocks;


    private StockMarket() {
        stocks = new ArrayList<>();
    }

    // Get the singleton instance
    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    // Add a stock to the market
    public void addStock(Tradable stock) {
        stocks.add(stock);
        System.out.println("Added: " + stock);
    }

    // Display all stocks in the market
    public void showAllStocks() {
        System.out.println("\n=== All Stocks in Market ===");
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }

    // Demo method to simulate stock trading
    public static void demo() {
        StockMarket market = StockMarket.getInstance();

        // Add stocks to the market
        AmazonStock amazonStock = new AmazonStock();
        GoogleStock googleStock = new GoogleStock();
        TeslaStock teslaStock = new TeslaStock();
        SMCIStock smciStock = new SMCIStock();
        JPMStock jpmStock = new JPMStock();

        market.addStock(amazonStock);
        market.addStock(googleStock);
        market.addStock(teslaStock);
        market.addStock(smciStock);
        market.addStock(jpmStock);

        // Simulate bids for each stock
        String[] amazonBids = {"3300", "3400", "3500", "3600", "3700", "3800"};
        String[] googleBids = {"2900", "2950", "3000", "3050", "3100", "3150"};
        String[] teslaBids = {"750", "760", "770", "780", "790", "800"};
        String[] smciBids = {"120", "130", "140", "150", "160", "170"};
        String[] jpmBids = {"165", "170", "175", "180", "185", "190"};

        System.out.println("\nSimulating market trends...");

        // Place bids on Amazon stock
        System.out.println("\nAmazon Stock:");
        for (String bid : amazonBids) {
            amazonStock.setBid(bid);
            System.out.println(amazonStock);
        }

        // Place bids on Google stock
        System.out.println("\nGoogle Stock:");
        for (String bid : googleBids) {
            googleStock.setBid(bid);
            System.out.println(googleStock);
        }

        // Place bids on Tesla stock
        System.out.println("\nTesla Stock:");
        for (String bid : teslaBids) {
            teslaStock.setBid(bid);
            System.out.println(teslaStock);
        }

        // Place bids on SMCI stock
        System.out.println("\nSMCI Stock:");
        for (String bid : smciBids) {
            smciStock.setBid(bid);
            System.out.println(smciStock);
        }

        // Place bids on JP Morgan stock
        System.out.println("\nJP Morgan Stock:");
        for (String bid : jpmBids) {
            jpmStock.setBid(bid);
            System.out.println(jpmStock);
        }

        // Display all stocks after bidding
        System.out.println("\nAll Stocks After Bidding:");
        market.showAllStocks();
    }
}
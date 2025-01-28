package edu.neu.csye7374;

public interface Tradable {
    /**
     * Place a bid to buy a stock.
     *
     * @param bid - the bid amount as a string.
     */
    void setBid(String bid);

    /**
     * Return a performance metric for the stock.
     * A large positive index indicates strong performance,
     * while a large negative index indicates poor performance.
     *
     * @return - the performance metric as an integer.
     */
    int getMetric();
}
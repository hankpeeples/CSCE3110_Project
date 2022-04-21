/*
 * The Pair class provides the transactions ArrayList to hold the type of
 * transaction and the amount of the transaction.
 */
package src;

public class Pair {
    private String type;
    private Double amount;

    public Pair(String type, Double amount) {
        this.type = type;
        this.amount = amount;
    }
}

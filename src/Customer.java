/*
 * Each customer will belong to the bank and will have the following attributes:
 *      - Name
 *      - Phone Number
 *      - Balance
 *      - Transaction list
 *      - ID number
 */
package src;

import java.util.ArrayList;

public class Customer {
    // Customer attributes
    private final int ID;
    private final String name;
    private final String phoneNumber;
    private Double balance;
    private ArrayList<Pair> transactions;

    // Customer constructor
    public Customer() {
        this.ID = 12345;
        this.name = "Henry Peeples";
        this.phoneNumber = "111-111-1111";
        this.balance = 100.00;
        this.transactions = new ArrayList<Pair>();
    }
}

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
//    HashTable<Integer, String, String, Double, ArrayList<Pair>> customersHash =
//            new HashTable<>();

    // Customer constructor
    public Customer(int ID, String name, String phoneNumber, Double balance,
                    ArrayList<Pair> transactions) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.transactions = transactions;
    }

    // return customers ID
    public int getId(Customer customer) {
        return customer.ID;
    }

    // return customers name
    public String getName(Customer customer) {
        return customer.name;
    }

    // return customers phone number
    public String getPhoneNumber(Customer customer) {
        return customer.phoneNumber;
    }

    // return customers balance
    public Double getBalance(Customer customer) {
        return customer.balance;
    }

    // return customers transactions
    public ArrayList<Pair> getTransactions(Customer customer) {
        return customer.transactions;
    }
}

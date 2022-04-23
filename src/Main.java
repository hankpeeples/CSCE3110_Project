package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("UNT");
        HashTable<Integer, String, String, Double, ArrayList<Pair>> customerList =
                new HashTable<>();

        customerList.printCustomerList();

        bank.addNewCustomer(customerList);

        customerList.printCustomerList();

        bank.addNewCustomer(customerList);

        customerList.printCustomerList();
    }
}

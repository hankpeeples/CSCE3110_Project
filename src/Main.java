package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("UNT");
        HashTable<Integer, String, String, Double, ArrayList<Pair>> customerList =
                new HashTable<>();

        ArrayList<Pair> henryTransactions = new ArrayList<>();
        ArrayList<Pair> benTransactions = new ArrayList<>();
        henryTransactions.add(new Pair("Initial Deposit", 100.00));
        benTransactions.add(new Pair("Initial Deposit", 200.00));

        customerList.insert(646534, "Henry Peeples", "111-222-3333",
                100.00, henryTransactions);
        customerList.insert(87654, "Ben", "333-222-1111",
                200.00, benTransactions);
        customerList.insert(87654, "Someone", "333-222-1111",
                23400.00, benTransactions);

        customerList.printCustomerList();

        customerList.remove(646534);

        customerList.printCustomerList();


//        System.out.println();
    }
}

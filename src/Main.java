package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String, String, Double, ArrayList<Pair>> table =
                new HashTable<>();

        ArrayList<Pair> transactions = new ArrayList<>();
        transactions.add(new Pair("Initial Deposit", 100.00));

        table.insert(12345, "Henry", "111-222-3333",
                100.00, transactions);
        System.out.println(table.size());
        System.out.println(table.get(12345));
        System.out.println(table.remove(12345));
        System.out.println(table.remove(12345));
    }
}

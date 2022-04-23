package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        HashTable<Integer, String, String, Double, ArrayList<Pair>> customerList =
                new HashTable<>();
        int choice = -1;

        do {
            choice = bank.showMenu();

            switch (choice) {
                case 1:
                    bank.addNewCustomer(customerList);
                    break;
                case 2:
                    // deposit
                    break;
                case 3:
                    // Withdraw
                    break;
                case 4:
                    // show specific customers transactions
                    break;
                case 0:
                    System.out.println("\nGoodbye...");
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}

/*
 * The HashTable class will hold all the customers, so they can be easily
 * found when a search is called.
 */
package src;

import java.util.ArrayList;

public class HashTable<K, N, PN, B, T> {
    private final ArrayList<HashNode<K, N, PN, B, T>> list;
    private final int numBuckets;
    private int size;

    // constructor
    public HashTable() {
        list = new ArrayList<>();
        numBuckets = 1000;
        size = 0;

        // create empty chains
        for (int i = 0; i < numBuckets; i++) {
            list.add(null);
        }
    }

    // find list size
    public int size() {
        return size;
    }

    // return whether list is empty or not
    public boolean isEmpty() {
        return size() == 0;
    }

    // hash function
    private int hashFunction(K key) {
        return ((int) key % numBuckets);
    }

    // find and return a specific customer
    public HashNode<K, N, PN, B, T> find(K key) {
        // find head of chain for given key
        int index = hashFunction(key);

        HashNode<K, N, PN, B, T> head = list.get(index);

        // search for key in chain
        while (head != null) {
            if (head.key.equals(key)) {
                // return the all customer info
                return head;
            }
            head = head.next;
        }
        // key not found
        return null;
    }

    // add customer to the table
    public void insert(K key, N name, PN phoneNumber, B balance, T transactions) {
        // find head of chain
        int index = hashFunction(key);
        HashNode<K, N, PN, B, T> head = list.get(index);

        // check if key is already in the table
        while (head != null) {
            if (head.key.equals(key)) {
//                head.name = name;
//                head.phoneNumber = phoneNumber;
//                head.balance = balance;
//                head.transactions = transactions;
                System.out.println("Key found in table at " + index + ", " +
                        "nothing inserted.");
                return;
            }
            head = head.next;
        }

        // insert key in chain
        size++;
        head = list.get(index);
        HashNode<K, N, PN, B, T> newNode = new HashNode<K, N, PN, B, T>(key, name,
                phoneNumber, balance, transactions);
        newNode.next = head;
        list.set(index, newNode);

        // I will be assuming the hash table will never exceed 1000 customers
        // so there is no need to catch exceeding bounds.
    }

    // remove a given customer
    public K remove(K key) {
        int index = hashFunction(key);
        HashNode<K, N, PN, B, T> head = list.get(index);

        // search for key in chain
        HashNode<K, N, PN, B, T> prev = null;
        while (head != null) {
            // key found
            if (head.key.equals(key)) {
                break;
            }
            // else keep moving in chain
            prev = head;
            head = head.next;
        }
        // key was not present
        if (head == null) {
            return null;
        }

        size--;

        // remove key
        if (prev != null) {
            prev.next = head.next;
        } else {
            list.set(index, head.next);
        }

        return head.key;
    }

    // print list of every customer
    public void printCustomerList() {
        System.out.println("\n\t- - - - - - - - - - - - - - - - - - - - - - " +
                "- - -");
        System.out.println("\t|\t\tTotal customers: " + size() + "\t\t|");
        System.out.println("\t- - - - - - - - - - - - - - - - - - - - - - - -" +
                " -");
        for (int i = 0; i < numBuckets; i++) {
            if (list.get(i) != null) {
                HashNode<K, N, PN, B, T> customer = list.get(i);
                ArrayList<Pair> transactions = (ArrayList<Pair>) customer.transactions;
                System.out.println("\t\u001b[32mID: \u001b[0m" + customer.key);
                System.out.println("\t\u001b[32mName: \u001b[0m" + customer.name);
                System.out.println("\t\u001b[32mPhone number: \u001b[0m" + customer.phoneNumber);
                System.out.printf("\t\u001b[32mBalance: \u001b[0m$%.2f\n",
                        customer.balance);
                System.out.println("\t\u001b[32mTransactions: \u001b[0m");
                if (!transactions.isEmpty())
                    for (int j = 0; j < transactions.size(); j++)
                        Pair.showList(transactions.get(j));
                else
                    System.out.println("\t- N/A");
                System.out.println("\t- - - - - - - - - - - - - - - - - - - -" +
                        " - - - - -");
            }
        }
    }
}

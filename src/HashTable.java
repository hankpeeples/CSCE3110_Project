/*
 * The HashTable class will hold all the customers, so they can be easily
 * found when a search is called.
 */
package src;

import java.util.ArrayList;

public class HashTable<K, N, PN, B, T> {
    private ArrayList<HashNode<K, N, PN, B, T>> list;
    private int numBuckets;
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

    // get list size
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

    // get bucket index
    private int getBucketIndex(K key) {
        int index = hashFunction(key) % numBuckets;
        // hash code can return a negative number
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // find and return a specific customer
    public K get(K key) {
        // find head of chain for given key
        int index = getBucketIndex(key);

        HashNode<K, N, PN, B, T> head = list.get(index);

        // search for key in chain
        while (head != null) {
            if (head.key.equals(key)) {
                return head.key;
            }
            head = head.next;
        }
        // key not found
        return null;
    }

    // add customer to the table
    public void insert(K key, N name, PN phoneNumber, B balance, T transactions) {
        // find head of chain
        int index = getBucketIndex(key);
        HashNode<K, N, PN, B, T> head = list.get(index);

        // check if key is already in the table
        while (head != null) {
            if (head.key.equals(key)) {
                head.name = name;
                head.phoneNumber = phoneNumber;
                head.balance = balance;
                head.transactions = transactions;
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
        int index = getBucketIndex(key);
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
}

/*
 * The HashTable class will hold all the customers, so they can be easily
 * found when a search is called.
 */
package src;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> list;
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
    public int size() { return size; }

    // return whether list is empty or not
    public boolean isEmpty() { return size() == 0; }

    // hash function
    private final int hashFunction(K key) {
        return Objects.hashCode(key);
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

        HashNode<K, V> head = list.get(index);

        // search for key in chain
        while (head != null) {
            if (head.key.equals(key) && head.key == key) {
                return head.key;
            }
            head = head.next;
        }
        // key not found
        return null;
    }

    // add customer to the table
    public void add(K key, V value) {
        // find head of chain
        int index = getBucketIndex(key);
        HashNode<K, V> head = list.get(index);

        // check if key is already in the table
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // insert key in chain
        size++;
        head = list.get(index);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        list.set(index, newNode);

        // I will be assuming the hash table will never exceed 1000 customers
        // so there is no need to catch exceeding bounds.
    }

    // remove a given customer
    public K remove(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = list.get(index);

        // search for key in chain
        HashNode<K, V> prev = null;
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

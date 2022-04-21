/*
 * Class HashNode is a node of chains
 */
package src;

public class HashNode<K, N, PN, B, T> {
    K key; // ID
    N name;
    PN phoneNumber;
    B balance;
    T transactions;
    HashNode<K, N, PN, B, T> next;

    public HashNode(K key, N name, PN phoneNumber, B balance, T transactions) {
        this.key = key;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.transactions = transactions;
    }
}

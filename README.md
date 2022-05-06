# Banking Management System

### Overview

This is a CSCE 3110 project made by Henry Peeples.

* The `Bank` class provides the following general functionalities of a Bank.
    * Adding a new customer.
    * Depositing 'money' from a specific customer account.
    * Withdrawing 'money' from a specific customer account.
    * Showing a specific customers transactions.
    * Closing (removing) an account from the system.
    * Editing customer details such as name and phone number.
    * Showing a list of all customer account. **Note:** This can be a rather
      long list (~1000 accounts on a full hash table)
      <br><br>
* The `HashTable` class holds all customers (individual `HashNode`'s) of the
  Bank in a hash table.
  This allows for faster searching of customer accounts. This class provides
  all general functions of a hash table including:
    * `isEmpty()` returns whether the table is empty or not.
    * `size()` returns total number of objects in the table.
    * `find()` returns a specific customers object for manipulation.
    * `insert()` adds a new customer object to the hash table.
    * `remove()` removes a customer object from the table.
    * `printCustomerList()` prints a list of all customer accounts.
      <br><br>
* The `HashNode` class holds the details of a customer account including:
    * Id number
    * Name
    * Phone Number
    * Balance
    * List of transactions
      <br><br>
* The `Pair` class allows the insertion of a String value and a Double value
  into a customers' transaction list.
    * The String value is the type of transaction.
        * 'Initial Deposit' on account creation.
        * 'Deposit' on a deposit operation.
        * 'Withdraw' on a withdraw operation.
    * The Double value is the amount of 'money' being dealt.

The main branch is the complete **CLI** implementation of the Bank System.

### Usage

To compile, run `javac src/*.java`
<br>
Now execute `java src/Main` to run program.
<br>
You can now clean the project folder by running `rm -f src/*.class` if you wish.

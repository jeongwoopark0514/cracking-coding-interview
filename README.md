# cracking-coding-interview

Study and Practice Cracking the Coding Interview 6th edition

## Big O

* Big O, Big Omega, Big theta
* Best case, Worst case, Expected case
* Space Complexity
* Drop the constants: Big O just describes the rate of increase so O(2N) -> O(N)
* Drop the Non-Dominant Terms: O(N^2 + N) -> O(N^2)
* Amortized Time: Applicable to ArrayList. It allows us to describe that the worst case happens every once in a while. Once it happens, it won't happen again for so long that the cost is amortized. X inestions take O(2X) time. The amortized time for each insertion is O(1).
* Log N Runtimes: When you see a problem where the number of elements in the problem space gets halved each time.
* Recursive Runtimes: When you have a recursive function that makes multiple calls, the runtime will often look like O(branches^depth)

## Arrays and Strings
Note that array questions and string questions are often interchangeable. 

### Hash Tables
A hash table is a data structure that maps keys to values for highly efficient lookup.

How to insert a key and value?
1. First, compute the key's hash code (int or long). Two different keys can have the same hash code, as there may be an infinite number of keys and a finite number of ints.
2. Then, map the hash code to an index in the array. e.g. hash(key) % array_length. Two different hash codes could, of course, map to the same index.
3. At this index, there is a linked list of keys and values. Store the key and value in this index.

How to retrieve the value pair by its key?
1. Compute the hash code from the key
2. Compute the index from the hash code.
3. Search through the linked list for the value with this key.

The worse case runtime is O(n) when all keys collide.
We can implement the hash table with a balanced binary search tree. O(log N) lookup time. Potentially use less space. We can also iterate through the keys in order.

### ArrayList & Resizable Arrays
When you need an array like data structure with dynamic resizing, you would use an ArrayList.
Inserting N elements takes O(N) work total. Each insertion is O(1) on average, even though some insertions take O(N) time in the worst case.

### StringBuilder
StringBuilder simply creates a resizable array of all the strings, copying them back to a string only when necessary.

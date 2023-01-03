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

## Linked List

In a singly linked list, each node points to the next node in the linked list. A doubly linked list gives each node pointers to both the next node and the previous node.

Unlike an array, to find the Kth element in the list, you will need to iterate through K elements.

### Deleting a Routes.Node
You should set prev.next equal to n.next. If the list is doubly linked, also update n.next to set n.next.prev equal to n.prev.
The important things to remember are (1) to check for the null pointer and (2) to update the head or tail pointer as necessary.

### The Runner Technique
The runner technique is used in many linked list problems. The runner technique means that you iterate though the linked list with two pointers simultaneously, with one ahead of the other.

### Recursive Problems
A number of linked list problems rely on recursion. IF you're having trouble solving a linked list problem you should explore if a recursive approach will work. 
You should remember tha recursive algorithms take at least O(n) space, where n is the depth of the recursive call.

## Stacks and Queues


### Implementing a Stack
A stack uses LIFO ordering.

* pop()
* push(item)
* peek()
* isEmpty()

Unlike an array, a stack does not offer constant-time access to the ith item. However, it does allow constant adds and removes as it does not require shifting elements around.
Stacks are useful in certain recursive algorithms. Sometimes you need to push temporary data onto a stack as you recurse, but then remove them as you backtrack.
Stacks can also be used to implement a recursive algorithm iteratively.

### Implementing a Queue 
A queue implements FIFO ordering.

* add(item)
* remove()
* peek()
* isEmpty()

Queues are oftne used in breadth-first search or implementing a cache.
In breadth-first search, for example, we used a queue to store a list of the nodes that we need to process. 
Each time we process a node, we add its adjacent nodes to the back of the queue. This allows us to process nodes in the order in which they are viewed.


## Trees and Graphs

### Types of Trees
A tree is a data structure composed of nodes.
* Each tree has a root node.
* The root node has zero or more child nodes.
* Each child node has zero or more child nodes and so on.

The tree cannot contain cycles. The nodes may or may not be in a particular oder, they could have any data type as values, and they may or may not have links back to their parent nodes.
We typically do not use a Tree class.

A binary tree is a tree in which each node has up to two children. Not all trees are binary trees.

A node is called a leaf node if it has no children.

A binary search tree is a binary tree in which every node fits a specific ordering property: all left descendents <= n < all right descendents. This must be true for each node n.
This inequality must be true for all of a node's descendents, not just its immediate children.

Two common types of balanced trees are red-black trees and AVL trees. 

A complete binary tree is a binary tree in which every level of the tree is fully filled, except for perhaps the last level. 
To the extent that the last level is filled, it is filled left to right.

A full binary tree is a binary tree in which every node has either zero or two children. That is, no nodes have only one child.

A perfect binary tree is one that is both full and complete. All leaf nodes will be at the same level, and this level has the maximum number of nodes.


### Binary Tree Traversal
* In-Order Traversal: In-order traversal means to visit the left branch, then the current node, and finally, the right branch.
* Pre-Order Traversal: Pre-order traversal visits the current node before its child nodes. The root is always the first node visited.
* Post-Order Traversal: Post-order traversal visits the current node after its child nodes. In a post-order traversal, the root is always the last node visited.

### Binary Heaps (Min-Heaps and Max-Heaps)
Max-heaps are essentially equivalent, but the elements are in descending order rather than ascending order.

A min-heap is a complete binary tree (totally filled other than the rightmost elements on the last level) where each node is smaller than its children. The root, therefore, is the minimum element in the tree.

* Insert: First inserte the element at the bottom and fix the tree by swapping the new element with its parents. O(log n)
* Extract Minimum Element: We remove the minimum element and swap it with the last element in the heap.

### Tries (Prefix Tree)
A Trie is a variant of an n-ary tree in which characters are stored at each node. Each path down the tree may represent a word. 
The * nodes (null nodes) are often used to indicate complete words. For example, the fact that there is a * node under MANY indicates that MANY is a complete word. 
Very commonly, a trie is used to store the entire (English) language for quick prefix lookups.


## Graphs
A tree is actually a type of graph, but not all graphs are trees. A tree is a connected graph without cycles.

* Graphs can be either directed or undirected.
* The graph might consist of multiple isolated subgraphs. If there is a path between every pair of vertices, it is called a connected graph.
* The graph can also have cycles (or not). An acyclic graph is one without cycles.

### Adjacency List
Most common way to represent a graph. 
Every vertex (or node) stores a list of adjacent vertices.

### Adjacency Matrices
An adjacency matrix is an NxN boolean matrix.
In an undirected graph, an adjacency matrix will be symmetric.

### Routes.Graph Search
In depth-first search (DFS), we start at the root and explore each branch completely before moving on to the next branch. That is, we go deep first before we go wide.
In breadth-first search (BFS), we start at the root and explore each neighbour before going on to any of their children. That is, we go wide before we go deep.

For visiting every node, DFS is preferred as it is a bit simpler.

For finding a shortest path, BFS is preferred.

DFS is recursive and BFS is iterative using a queue.

Bidirectional search is used to find the shortest path between a source and destination node. It operates by essentially running two simultaneous breadth-first searches, one from each node. When their searches collide, we have found a path.
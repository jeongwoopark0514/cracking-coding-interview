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
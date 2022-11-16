import java.util.Hashtable;
import java.util.Locale;

public class Palindrome {
//    Hints: #106, #121, #134, #136
//    #106: Do not have to generate all permutations
//    #121: What characteristics would a string that is a permutation of a palindrome have?
//    #134: Have you tried a hash table? You should be able to get this down to O(N)
//    #136: Can you reduce the space usage by using a bit vector?

    // my solution
    public static boolean palindrome_check(String str) {
        str = str.toLowerCase(Locale.ROOT);
        char[] chrarr = str.toCharArray();
        Hashtable<Character, Integer> ht1 = new Hashtable<>();

        for(int i = 0; i < chrarr.length; i++) {
            if(chrarr[i] != ' ') {
                ht1.put(chrarr[i], ht1.getOrDefault(chrarr[i], 0)+1);
            }
        }

        int counter = 0;
        // for-each loop
        for(Character key : ht1.keySet()) {
            if(ht1.get(key) % 2 != 0) {
                counter += 1;
            }
            if(counter >= 2) {
                return false;
            }
        }
        return true;
    }

    // solution 1
    public static boolean isPermutationPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);

        // Check that no more than one character has an odd count.
        boolean foundOdd = false;
        for(int count : table) {
           if(count % 2 == 1) {
               if(foundOdd) {
                   return false;
               }
               foundOdd = true;
           }
        }
        return true;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static int[] buildCharFrequencyTable(String phrase) {
        // Create an array of the length of alphabets
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    // Solution 2
    // Still O(n), not necessarily more optimal.
    // We check the number of odd counts as we go along.

    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
                if(table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    // Solution 3
    public static boolean isPermutationOfPalindrome2(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    public static int createBitVector(String phrase) {
        int bitVector = 0;
        for(char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    public static int toggle(int bitVector, int index) {
        if(index < 0) return bitVector;

        int mask = 1 << index;
        if((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    // Check that exactly one bit is set by subtracting one from the integer and Anding it with the original integer.
    public static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }



    public static void main(String[] args) {
        System.out.println(palindrome_check("Tact Coa"));
        System.out.println(isPermutationPalindrome("Tact Coa"));
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
        System.out.println(isPermutationOfPalindrome2("Tacth Coa"));
    }
}

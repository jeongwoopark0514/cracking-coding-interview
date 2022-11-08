
public class MyAnswer {

//    hint #44, #117, #132
    public static boolean isUnique(String str) {
        // Ascii string is 127, Unicode is 2^21
        if(str.length() > 128) return false;
        boolean[] possible_chars = new boolean[128];

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if(possible_chars[index]) {
                return false;
            } else {
                possible_chars[index] = true;
            }
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            // Calculate the position of the character
            int val = str.charAt(i) - 'a';

            // Compute the binary if they have any common bit
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            // Merge so that checker has an updated information
            checker |= (1 << val);
        }
        return true;
    }

    // Time complexity is O(n) : string length
    // Space complexity is O(1).

    // When additional data structures cannot be used,
    // 1. Compare every character of the string to every other character of the string.
    // => Time: O(n^2), space: O(1)
    // 2. Sort the string in O(nlogn) time and linearly chec kthe string for neighboring characters that are identical.

    public static void main(String[] args) {
//        System.out.println(isUnique("fffffffffff"));
        System.out.println(isUnique2("aaaaa"));
//        System.out.println(isUnique("f"));
//        System.out.println(isUnique(""));
    }
}



import java.util.Arrays;

public class Permute {
    //  Hints: #7, #84, #722, #73

    // 1. Sort two strings
    public static boolean permutation1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();
            Arrays.sort(s1Arr);
            Arrays.sort(s2Arr);

            return Arrays.equals(s1Arr, s2Arr);
        }
    }

    // 2. Count the chars of each string.
    // Ask interviewer size of the character set
    public static boolean permutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            int[] ascii = new int[128];
            for(int i = 0; i < s1.length(); i++) {
                ascii[s1.charAt(i)] += 1;
            }

            for(int i = 0; i < s2.length(); i++) {
                ascii[s2.charAt(i)] -= 1;
                if(ascii[s2.charAt(i)] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation2("abcdef", "adebcf"));
    }
}

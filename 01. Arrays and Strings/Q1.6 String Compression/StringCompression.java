public class StringCompression {
//    Hint #92 #110
//  92: Do the easy thing first. Compress the string, then compare the lengths.
//  Be careful that you aren't repeatedly concatenating strings together. This can be very
//inefficient.

    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        char temp = '\0';
        int count = 0;
        for(char c : str.toCharArray()) {
            if(temp!=c) {
                if (temp != '\0') {
                    sb.append(temp);
                    sb.append(count);
                }
                count = 0;
                temp = c;
            }
            count++;
        }
        if (temp != '\0') {
            sb.append(temp);
            sb.append(count);
        }

        if(sb.toString().length() < str.length()) {
            return sb.toString();
        } else {
            return str;
        }
    }

    // more optimal
    public static String compress(String str) {
        // Check final length and return input string if it would be longer
        int finalLength = countCompression(str);
        System.out.println(finalLength);
        if(finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;

        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // if next character is different than current, increase the length;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}

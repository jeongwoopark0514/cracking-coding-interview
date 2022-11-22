public class StringRotation {
//    Hints: #34, #88, # 7 04
//34: If a string is a rotation of another, then it's a rotation at a particular point. For example,
//a rotation of waterbottle at character 3 means cutting waterbottle at character 3
//and putting the right half (erbottle) before the left half (wat).

// 88: We are essentially asking if there's a way of splitting the first string into two parts, x and
//y, such that the first string is xy and the second string is yx. For example, x = wat and
//y = erbottle. The first string is xy = waterbottle. The second string is yx =
//erbottlewat.

    // 704: Each connected subgraph represents a group of synonyms. To find each group, we can
    //do repeated breadth-first (or depth-first) searches.


    public static boolean rotationString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        StringBuilder sbFront = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(j)) {
                sbFront.append(s1.charAt(i));
            } else {
                j++;
            }
        }

        return isSubstring(s2, sbFront.toString());
    }

    // se will always be the substring of s1s1.
    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if(len == s2.length() && len > 0) {
            String s1s1 = s1+s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    // Returns true if s2 is substring of s1
    public static boolean isSubstring(String s1, String s2){
        if(s1.length()<s2.length()) return false;
        if(s1.length()==s2.length()) return s1.equals(s2);
        for(int i=0;i<=s1.length()-s2.length();i++){
            if(s1.charAt(i)==s2.charAt(0)){
                int matchLength=1;
                for(int j=1;j<s2.length();j++){
                    if(s1.charAt(i+j)!=s2.charAt(j)){
                        break;
                    }
                    matchLength++;
                }
                if(matchLength==s2.length()) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotationString("waterbottle", "erbottlewat"));
    }
}

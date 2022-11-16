import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneAway {
//    Hints:#23, #97, #130
//    23: Start with the easy thing. Can you check each of the conditions separately?
//    97: What is the relationship between the "insert character" option and the "remove character" option? Do these need to be two separate checks?
//    130: Can you do all three checks in a single pass?

    public static boolean check_one_edit(String str1, String str2) {
        boolean edit = false;

        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        } else {
            ArrayList<String> strarr1 = new ArrayList<String>(Arrays.asList(str1.split("")));
            ArrayList<String> strarr2 = new ArrayList<String>(Arrays.asList(str2.split("")));
            boolean difflen = false;
            if(strarr1.size() < strarr2.size()) {
                difflen = true;
                for (char c : str1.toCharArray()) {
                    strarr1.add(" ");
                }
            }
            if(strarr1.size() > strarr2.size()) {
                difflen = true;
                for (char c : str2.toCharArray()) {
                    strarr2.add(" ");
                }
            }

            for(int i = 0; i < strarr1.size(); i++) {
                if(edit) {
                    if(difflen) {
                        if(strarr1.get(i).equals(strarr2.get(i-1))) {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        if(strarr1.get(i).equals(strarr2.get(i))) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
                if(!strarr1.get(i).equals(strarr2.get(i))) {
                    edit = true;
                }
            }
            return true;
        }
    }

    public static boolean oneEditAway(String first, String second) {
        // Check lengths
        if(Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // Get shorter and longer string
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() > second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;

        boolean foundDifferece = false;
        while(index2 < s2.length() && index1 < s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                // If the difference is found already
                if(foundDifferece) return false;
                foundDifferece = true;

                if(s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check_one_edit("pale", "ple"));
        System.out.println(check_one_edit("pales", "pale"));
        System.out.println(check_one_edit("pale", "bale"));
        System.out.println(check_one_edit("pale", "bake"));
        System.out.println();
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pale"));
        System.out.println(oneEditAway("pale", "bale"));
        System.out.println(oneEditAway("pale", "bake"));
    }
}

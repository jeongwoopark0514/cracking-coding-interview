public class Urlify {

    // my idea
    public static String urlify(String str, int len) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if(arr[i] == 32) {
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void urlify2(char[] strarr, int len) {
        int spaceCount = 0;
        for(int i = 0; i < len; i++) {
            if(strarr[i] == ' ') {
                spaceCount ++;
            }
        }
        int index = len + spaceCount*2;
        if(len < strarr.length) strarr[len] = '\0';
        System.out.println(strarr.length);
        System.out.println(len);
        for(int i = len - 1; i >= 0; i--) {
            if(strarr[i] == ' ') {
                strarr[index - 1] = '0';
                strarr[index - 2] = '2';
                strarr[index - 3] = '%';
                index = index - 3;

            } else {
                strarr[index - 1] = strarr[i];
                index--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        System.out.println(urlify(str, 13));
        urlify2(arr, trueLength);
    }
}


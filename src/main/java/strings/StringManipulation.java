package strings;

public class StringManipulation {
    //Leetcode 151
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Step 1: Skip trailing spaces for the current word
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // If we've reached the start of the string, break
            if (i < 0) break;

            // Step 2: Find the front end of the current word
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Step 3: Append the found word to our result
            if (sb.length() > 0) {
                sb.append(" ");
            }
            // s.substring extraction range is [i + 1, j + 1]
            sb.append(s.substring(i + 1, j + 1));
        }

        return sb.toString();
    }
}

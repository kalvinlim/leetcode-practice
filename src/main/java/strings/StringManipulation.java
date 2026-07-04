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


    //Reverse in place of input array
    //Leetcode 186? - Premium
    public static void reverseWords(char[] s) {
        // Step 1: Reverse the entire character array
        reverse(s, 0, s.length - 1);

        // Step 2: Reverse each individual word
        int start = 0;
        for (int end = 0; end <= s.length; end++) {
            // When we find a space or reach the end of the array
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1; // Move start pointer to the beginning of the next word
            }
        }
    }

    // Helper function to reverse a portion of the array in-place
    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    private static final char[][] MAPPINGS = {
            {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
    };

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        backtrack(0, new StringBuilder(), result, digits);
        return result;
    }

    private static void backtrack(int i, StringBuilder str, List<String> result, String digits) {
        if (i >= digits.length()) {
            result.add(str.toString());
            return;
        }

        char d = digits.charAt(i);

        for (char c: MAPPINGS[Character.getNumericValue(d)]) {
            str.append(c);
            backtrack(i + 1, str, result, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

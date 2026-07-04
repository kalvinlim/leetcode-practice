import org.junit.Before;
import org.junit.Test;
import strings.StringManipulation;

import static org.junit.Assert.assertEquals;

public class StringManipulationTest {
    @Before
    public void setup() {
      
    }

    @Test
    public void testReverseWordsBasic() {
        assertEquals("world Hello", StringManipulation.reverseWords("Hello world"));
    }

    @Test
    public void testReverseWordsMultipleSpaces() {
        assertEquals("blue is sky The", StringManipulation.reverseWords("  The sky is blue  "));
    }

    @Test
    public void testReverseWordsSingleWord() {
        assertEquals("hello", StringManipulation.reverseWords("hello"));
    }

    @Test
    public void testReverseWordsEmptyString() {
        assertEquals("", StringManipulation.reverseWords(""));
    }

    @Test
    public void testReverseWordsOnlySpaces() {
        assertEquals("", StringManipulation.reverseWords("   "));
    }

    @Test
    public void testReverseWordsThreeWords() {
        assertEquals("Java Practice LeetCode", StringManipulation.reverseWords("LeetCode Practice Java"));
    }

    @Test
    public void testReverseWordsWithLeadingSpaces() {
        assertEquals("world Hello", StringManipulation.reverseWords("   Hello world"));
    }

    @Test
    public void testReverseWordsWithTrailingSpaces() {
        assertEquals("world Hello", StringManipulation.reverseWords("Hello world   "));
    }

    // Tests for reverseWords(char[] s) - in-place reversal
    @Test
    public void testReverseWordsCharArrayBasic() {
        char[] input = "Hello world".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("world Hello", new String(input));
    }

    @Test
    public void testReverseWordsCharArraySingleWord() {
        char[] input = "hello".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("hello", new String(input));
    }

    @Test
    public void testReverseWordsCharArrayThreeWords() {
        char[] input = "the sky is blue".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("blue is sky the", new String(input));
    }

    @Test
    public void testReverseWordsCharArrayWithMultipleSpaces() {
        char[] input = "a  good   example".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("example   good  a", new String(input));
    }

    @Test
    public void testReverseWordsCharArrayTwoWords() {
        char[] input = "LeetCode Practice".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("Practice LeetCode", new String(input));
    }

    @Test
    public void testReverseWordsCharArrayWithLeadingSpace() {
        char[] input = " hello world".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("world hello ", new String(input));
    }

    @Test
    public void testReverseWordsCharArrayWithTrailingSpace() {
        char[] input = "hello world ".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals(" world hello", new String(input));
    }

    @Test
    public void testReverseWordsCharArrayFourWords() {
        char[] input = "Java is awesome lang".toCharArray();
        StringManipulation.reverseWords(input);
        assertEquals("lang awesome is Java", new String(input));
    }

}

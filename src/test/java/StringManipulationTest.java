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

}

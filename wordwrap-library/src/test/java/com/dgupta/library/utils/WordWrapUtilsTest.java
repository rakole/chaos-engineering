package com.dgupta.library.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.dgupta.library.utils.WordWrapUtils.wrapIndividualLines;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordWrapUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Long line splits on white space")
    public void longLineSplitsOnWhiteSpace() {
        var output = wrapIndividualLines("/n", "hello world", 5);
        assertEquals("hello/nworld", output);
    }

    @Test
    @DisplayName("Long line splits on two white spaces")
    public void longLineWithTwoSpacesInMiddle() {
        var output = wrapIndividualLines("/n", "hello  world", 5);
        assertEquals("hello/nworld", output);

    }

    @Test
    @DisplayName("Long line with a lot of white splaces in the middle")
    public void longLineALotOfWhiteSpaceInMiddle() {
        var output = wrapIndividualLines("/n", "hello               world", 5);
        assertEquals("hello/nworld", output);
    }


    @Test
    @DisplayName("whitespace is preserved after new line")
    public void whitespacePreservedAfterNewLine() {
        var output = wrapIndividualLines("/n", "hello\n  world", 5);
        assertEquals("hello/nworld", output);
    }

    @Test
    @DisplayName("single letter")
    public void oneLetter() {
        var output = wrapIndividualLines("/n", "a", 5);
        assertEquals("a", output);
    }

    @Test
    @DisplayName("short line with no white space")
    public void shortLineNoWhitespace() {
    }

    //TODO
    @Test
    @DisplayName("short line with white space")
    public void shortLineHasWhitespace() {
    }

    //TODO
    @Test
    @DisplayName("empty text")
    public void emptyText() {
    }

    //TODO
    @Test
    @DisplayName("new line character preserved")
    public void newLineCharacterPreserved() {
    }


    //TODO
    @Test
    @DisplayName("carriage return removed")
    public void carriageReturnRemoved() {
    }


    //TODO
    @Test
    @DisplayName("carriage return removed")
    public void whitespaceConservedAfterNewLine() {
    }

    //TODO
    @Test
    public void wrapRightTrimsWhitespaceBeforeNewLine() {
    }

    //TODO
    @Test
    public void longWordForcesBreak() {
    }

    //TODO
    @Test
    public void longWordForcesBreakNoHyphens() {
    }

    //TODO
    @Test
    public void breakOnCommaDoesNotHappenWithoutSpaceAfter() {
    }

    //TODO
    @Test
    public void noHyphenAfterDigits() {
    }

    //TODO
    @Test
    public void breakOnCommasWithDigits() {
    }

    //TODO
    @Test
    public void longThenShort() {
    }

    //TODO
    @Test
    public void longThenShortWithMoreLines() {
    }

    //TODO
    @Test
    public void endWithNewLine() {
    }

    //TODO
    @Test
    public void spaceAndQuestionMark() {
    }

    //TODO
    @Test
    public void dontBreakOnQuestionMark() {
    }

    //TODO
    @Test
    public void breakOnQuote() {
    }

    //TODO
    @Test
    public void breakQuoteInMiddle() {
    }

    //TODO
    @Test
    public void shortThenLong() {
    }

    //TODO
    @Test
    public void longWhitespaceThenWord() {
    }

    //TODO
    @Test
    public void longWhitespaceLastLine() {
    }

    //TODO
    @Test
    public void longWhitespaceThenNewLine() {
    }

    //TODO
    @Test
    public void conserveWhitespace() {
    }


    //TODO
    @Test
    public void testLeftTrimLeadingEmpty() {
    }

    //TODO
    @Test
    public void testLeftTrimLeadingSpaces0() {
    }

    //TODO
    @Test
    public void testLeftTrimLeadingSpaces1() {
    }

    //TODO
    @Test
    public void testLeftTrimLeadingSpaces3() {
    }


    //TODO
    @Test
    public void testRightTrimAtEnd() {
    }

    //TODO
    @Test
    public void testRightTrimNoSpace() {
    }

    //TODO
    @Test
    public void testRightTrimEmpty() {
    }

    //TODO
    @Test
    public void testRightTrimOnlySpace() {
    }


    //TODO
    @Test
    public void testStringWidth() {
    }

    //TODO
    @Test
    public void testNewLineOverride() {
    }

    //TODO
    @Test
    public void testSetWordChars() {
    }

    //TODO
    @Test
    public void testIncludeWordChars() {
    }

    //TODO
    @Test
    public void testExcludeWordChars() {
    }

    //TODO
    @Test
    public void testDontBreakLongWords() {
    }

    //TODO
    @Test
    public void testDontBreakLongWords2() {
    }

    //TODO
    @Test
    public void testFromInputStream() {
    }


}
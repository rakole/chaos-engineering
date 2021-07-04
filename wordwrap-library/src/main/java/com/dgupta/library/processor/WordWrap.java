package com.dgupta.library.processor;

import com.dgupta.library.constant.Constants;
import com.dgupta.library.utils.WordWrapUtils;

import java.io.Writer;


public class WordWrap {


    /**
     * Make private constructor to make class Singleton.
     */
    private WordWrap() {
        // prevent instantiation
    }


    /**
     * Sets the source to be wrapped and returns a builder to specify more
     * parameters.
     *
     * @param inputData source to be wrapped
     * @return builder
     */
    public static Builder from(String inputData) {
        return new Builder(inputData);
    }

    /**
     * Provides method chaining for specifying parameters to word wrap.
     */
    public static final class Builder {

        private final String inputData;
        private Number maxWidth = 80;
        private String newLine = "\n";
        private boolean breakWords = true;

        Builder(String inputData) {
            this.inputData = inputData;
        }


        /**
         * Sets the maximum width of a line using the {@code stringWidth} function. Word
         * wrapping/splitting will be attempted for lines with greater than
         * {@code maxWidth}. If not set the default is 80.
         *
         * @param maxWidth maximum width of a line using the {@code stringWidth}
         *                 function.
         * @return this
         * @throws IllegalArgumentException if {@code maxWidth} is less than or equal to
         *                                  zero
         */
        public Builder maxWidth(Number maxWidth) {
            WordWrapUtils.checkArgument(maxWidth.doubleValue() > 0);
            this.maxWidth = maxWidth;
            return this;
        }


        /**
         * Sets the newLine string to be used. If not set the default is '\n' (line feed
         * character).
         *
         * @param newLine string to be output on for a new line delimiter
         * @return this
         */
        public Builder newLine(String newLine) {
            this.newLine = newLine;
            return this;
        }


        /**
         * If a word is longer than {@code maxWidth} and {@code breakWords} is true then
         * such a word will be broken across two or more lines (with or without a hyphen
         * according to 
         *
         * @param breakWords if true then break words across lines
         * @return this
         */
        public Builder breakWords(boolean breakWords) {
            this.breakWords = breakWords;
            return this;
        }

        /**
         * Performs the wrapping of the source text and writes output to the given
         * {@link Writer}.
         *
         * @return out output for wrapped text
         */
        public String wrap() {
            try {

                return wordWrapString(inputData, newLine,(int) maxWidth);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // close all objects
            }
        }

        /**
         * @param input       the input which needs to be wrapped
         * @param breakLength at what length the string needs to be wrapped
         * @param lineBreak   which character to be used for new liner
         * @return wrapped string
         */
        public String wordWrapString(String input, String lineBreak, int breakLength) {
            if (breakLength <= 0)
                throw new IllegalArgumentException(Constants.MSG1);
            if (input.length() < breakLength)
                return input;
            return WordWrapUtils.wrapIndividualLines(lineBreak, input, breakLength);
        }
    }


}

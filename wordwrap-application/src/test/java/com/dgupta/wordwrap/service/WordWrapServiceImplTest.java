package com.dgupta.wordwrap.service;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WordWrapServiceImplTest {
    private Input input;
    private String expectedOutput;


    @InjectMocks
    private WordWrapServiceImpl wordWrapService;

    @BeforeEach
    void setUp() {

        expectedOutput = "The Battle of\r\n" +
                "Pontvallain,\r\n" +
                "part of the\r\n" +
                "Hundred Years'\r\n" +
                "War, took\r\n" +
                "place in the\r\n" +
                "Sarthe region\r\n" +
                "of north-west\r\n" +
                "France on 4\r\n" +
                "December 1370,\r\n" +
                "when a French\r\n" +
                "army under\r\n" +
                "Bertrand du\r\n" +
                "Guesclin\r\n" +
                "heavily\r\n" +
                "defeated an\r\n" +
                "English force\r\n" +
                "which had\r\n" +
                "broken away\r\n" +
                "from an army\r\n" +
                "commanded by\r\n" +
                "Sir Robert\r\n" +
                "Knolles. The\r\n" +
                "French\r\n" +
                "numbered 5,200\r\n" +
                "men, and the\r\n" +
                "English force\r\n" +
                "was\r\n" +
                "approximately\r\n" +
                "the same size.";
        input = Input.builder().breakLength(15).breakString("\r\n").input("The Battle of Pontvallain, " +
                "part of the Hundred Years' War, took place in the Sarthe region of north-west France " +
                "on 4 December 1370, when a French army under Bertrand du Guesclin heavily defeated an " +
                "English force which had broken away from an army commanded by Sir Robert Knolles. The " +
                "French numbered 5,200 men, and the English force was approximately the same size.").build();

    }

    @Test
    @DisplayName("Test if given output gets correct linebreaks")
    void wordWrap() {
        var result = wordWrapService.wordWrap(input.getInput(), input.getBreakLength(), "\r\n");
        assertEquals(expectedOutput.trim(), result.trim());
    }

    @Data
    @Builder
    static
    class Input {
        @NotNull(message = "Input string cannot be null")
        @NotEmpty(message = "Input string cannot be empty")
        private String input;
        @Min(value = 1, message = "The break length cannot be less than 1")
        private int breakLength;
        private String breakString;
    }
}
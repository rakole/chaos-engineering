package com.dgupta.wordwrap.controller;

import com.dgupta.wordwrap.WordWrapApplication;
import com.dgupta.wordwrap.api.WordWrapService;
import com.dgupta.wordwrap.constant.ValidationConfiguration;
import com.dgupta.wordwrap.service.WordWrapServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WordWrapController.class)
class WordWrapControllerTest {
    private Input input;

    private String expectedOutput;

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
        input = Input.builder().breakLength(5).breakString("\r\n").input("The Battle of Pontvallain, " +
                "part of the Hundred Years' War, took place in the Sarthe region of north-west France " +
                "on 4 December 1370, when a French army under Bertrand du Guesclin heavily defeated an " +
                "English force which had broken away from an army commanded by Sir Robert Knolles. The " +
                "French numbered 5,200 men, and the English force was approximately the same size.").build();

    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    WordWrapService wordWrapService;

    @MockBean
    ValidationConfiguration validationConfiguration;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("the controller should return wrapped line")
    public void wordWrapTest() throws Exception {
        given(wordWrapService.wordWrap(anyString(), anyInt(), anyString())).willReturn(expectedOutput);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/wordWrap")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk()).andReturn();
        String output = result.getResponse().getContentAsString();
        assertEquals(expectedOutput, output);
    }

    @Test
    @DisplayName("the controller should throw a validation error when the breakLength is less than 0")
    public void wordWrapException() throws Exception {
        input.setBreakLength(0);
        given(wordWrapService.wordWrap(anyString(), anyInt(), anyString())).willReturn(expectedOutput);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/wordWrap")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(status().isBadRequest()).andReturn();
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
package com.dgupta.wordwrap.controller;

import com.dgupta.wordwrap.api.WordWrapService;
import com.dgupta.wordwrap.constant.ValidationConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
public class WordWrapController {

    final WordWrapService wordWrapService;

    final ValidationConfiguration validationConfiguration;

    public WordWrapController(WordWrapService wordWrapService, ValidationConfiguration validationConfiguration) {
        this.wordWrapService = wordWrapService;
        this.validationConfiguration = validationConfiguration;
    }

    /**
     * Rest resource for word wrapping a given string
     *
     * @param input is a custom json object which provides fields for doing so
     * @return wrapped string
     */
    @PostMapping(value = "/wordWrap", produces = "application/vnd.company.app-v1+json")
    @Operation(description = "Rest endpoint for wrapping provided text." +
            "user needs to provide a break-length of more than 0, and optionally can " +
            "provide a custom break string to be used.", summary = "API for text wrapping."
    )
    public ResponseEntity<String> wordWrap(@Valid @RequestBody Input input) {
        return new ResponseEntity<>(wordWrapService.wordWrap(input.getInput(), input.getBreakLength(), input.getBreakString()), HttpStatus.OK);
    }

    @Data
    static
    class Input {
        @NotNull(message = "{input.notnull}")
        @NotEmpty(message = "{input.not.empty}")
        private String input;
        @Min(value = 1, message = "{length.min}")
        private int breakLength;
        private String breakString;
    }
}

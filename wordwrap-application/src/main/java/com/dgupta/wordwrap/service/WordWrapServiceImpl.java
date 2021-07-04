package com.dgupta.wordwrap.service;

import com.dgupta.library.processor.WordWrap;
import com.dgupta.wordwrap.api.WordWrapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WordWrapServiceImpl implements WordWrapService {
   

    @Value("${wordwrap.default.length}")
    private int defaultBreakLength;
    @Value("${wordwrap.default.character}")
    private String breakCharacter;

    /**
     * This service method calls wordwrap pojo from the library.
     *
     * @param input          the input which needs to be wrapped
     * @param breakLength    at what length the string needs to be wrapped
     * @param breakCharacter which character to be used for new liner
     * @return the input with word-wrapped at specified length.
     */
    public String wordWrap(String input, int breakLength, String breakCharacter) {
        if (breakLength == 0)
            breakLength = defaultBreakLength;
        if (breakCharacter == null || breakCharacter.isEmpty())
            breakCharacter = this.breakCharacter;
        StringBuilder sb = new StringBuilder();
        
        return WordWrap.from(input)
        		.maxWidth(breakLength)
        		.newLine(breakCharacter)
        		.wrap();

    }


}

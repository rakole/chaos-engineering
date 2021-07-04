package com.dgupta.wordwrap.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = Constants.VALIDATION)
public class ValidationConfiguration {
    public static String inputNotNull;
    public static String inputNotEmpty;
    public static String breakLengthMinLength;
}

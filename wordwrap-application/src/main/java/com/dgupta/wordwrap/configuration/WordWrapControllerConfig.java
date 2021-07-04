package com.dgupta.wordwrap.configuration;

import com.dgupta.wordwrap.interceptor.WordWrapInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WordWrapControllerConfig implements WebMvcConfigurer {

    private final WordWrapInterceptor WordWrapInterceptor;

    public WordWrapControllerConfig(WordWrapInterceptor WordWrapInterceptor) {
        this.WordWrapInterceptor = WordWrapInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(WordWrapInterceptor)
                .addPathPatterns("/wordWrap1/*");
    }
}

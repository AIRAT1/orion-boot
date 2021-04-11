package de.orion.config;

import de.orion.interceptor.InterceptorExample;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfiguration implements WebMvcConfigurer {
    private final InterceptorExample interceptorExample;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorExample).addPathPatterns("/persons/*");
    }
}

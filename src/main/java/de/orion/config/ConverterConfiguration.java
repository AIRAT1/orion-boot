package de.orion.config;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ConverterConfiguration {
    private final Set<Converter<?, ?>> converters;
    private final ConfigurableConversionService conversionService;

    @PostConstruct
    public void setup() {
        converters.forEach(conversionService::addConverter);
    }
}

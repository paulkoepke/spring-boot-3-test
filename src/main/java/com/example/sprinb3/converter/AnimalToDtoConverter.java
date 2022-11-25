package com.example.sprinb3.converter;

import com.example.sprinb3.dto.AnimalDto;
import com.example.sprinb3.entity.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalToDtoConverter implements Converter<Animal, AnimalDto> {
    @Override
    public AnimalDto convert(Animal source) {
        return new AnimalDto(source.getId(), source.getName(), source.getHeight(), source.getWeight());
    }
}

package com.example.sprinb3.converter;

import com.example.sprinb3.dto.AnimalDto;
import com.example.sprinb3.entity.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalDtoToAnimalConverter implements Converter<AnimalDto, Animal> {
    @Override
    public Animal convert(AnimalDto source) {
        Animal animal = new Animal();
        //Skip
        //animal.setId(source.id());
        animal.setName(source.name());
        animal.setHeight(source.height());
        animal.setWeight(source.weight());
        return animal;
    }
}

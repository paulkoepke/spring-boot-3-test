package com.example.sprinb3.facade;

import com.example.sprinb3.converter.Converter;
import com.example.sprinb3.dto.AnimalDto;
import com.example.sprinb3.entity.Animal;
import com.example.sprinb3.service.AnimalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class AnimalFacade {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private Converter<Animal, AnimalDto> animalToDtoConverter;

    @Autowired
    private Converter<AnimalDto, Animal> animalDtoToEntityConverter;


    public AnimalDto getById(Long id) {
        Animal animal = animalService.getById(id);
        return animalToDtoConverter.convert(animal);
    }

    public AnimalDto create(AnimalDto animalDto) {
        Animal animalToCreate = animalDtoToEntityConverter.convert(animalDto);
        Animal savedAnimal = animalService.create(animalToCreate);
        return animalToDtoConverter.convert(savedAnimal);
    }

    public List<AnimalDto> getAll() {
        return animalService.getAll().stream().map(animalToDtoConverter::convert).toList();
    }

    public void deleteById(Long id) {
        animalService.deleteById(id);
    }

    public AnimalDto updateById(Long id, AnimalDto animalDto) {
        Animal updateAnimal = animalDtoToEntityConverter.convert(animalDto);
        Animal savedAnimal = animalService.updateById(id, updateAnimal);
        return animalToDtoConverter.convert(savedAnimal);
    }
}

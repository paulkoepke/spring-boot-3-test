package com.example.sprinb3.service;

import com.example.sprinb3.dao.AnimalRepository;
import com.example.sprinb3.entity.Animal;
import com.example.sprinb3.exception.AnimalNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow(AnimalNotExistException::new);
    }

    public Animal create(Animal animalToCreate) {
        return animalRepository.save(animalToCreate);
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public void deleteById(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(AnimalNotExistException::new);
        animalRepository.delete(animal);
    }

    public Animal updateById(Long id, Animal updateAnimal) {
        Animal animal = animalRepository.findById(id).orElseThrow(AnimalNotExistException::new);
        animal.setName(updateAnimal.getName());
        animal.setHeight(updateAnimal.getHeight());
        animal.setWeight(updateAnimal.getWeight());
        return animal;
    }
}

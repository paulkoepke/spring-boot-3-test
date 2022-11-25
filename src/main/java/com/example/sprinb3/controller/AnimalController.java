package com.example.sprinb3.controller;

import com.example.sprinb3.dto.AnimalDto;
import com.example.sprinb3.exception.AnimalNotExistException;
import com.example.sprinb3.facade.AnimalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController {

    @Autowired
    private AnimalFacade animalFacade;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalDto getById(@PathVariable Long id) {
        return animalFacade.getById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalDto> getAll() {
        return animalFacade.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalDto create(@RequestBody AnimalDto animalDto) {
        return animalFacade.create(animalDto);
    }

    @PutMapping(path = "/{id}")
    public AnimalDto updateById(@PathVariable Long id, @RequestBody AnimalDto animalDto) {
        return animalFacade.updateById(id, animalDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        animalFacade.deleteById(id);
    }

    @ExceptionHandler(AnimalNotExistException.class)
    public ResponseEntity<String> notFoundExceptionHandler() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

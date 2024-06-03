package com.project.csv_controll.service.impl;

import com.project.csv_controll.entity.Person;
import com.project.csv_controll.repository.PersonRepository;
import com.project.csv_controll.service.ISavePersonService;
import org.springframework.stereotype.Service;

@Service
public class SavePersonServiceImpl implements ISavePersonService {

    private final PersonRepository personRepository;

    public SavePersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        this.personRepository.save(person);
    }
}

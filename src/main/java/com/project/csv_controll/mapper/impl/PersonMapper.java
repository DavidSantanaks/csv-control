package com.project.csv_controll.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.entity.Person;
import com.project.csv_controll.mapper.ICustomMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper implements ICustomMapper<PersonDTO, Person> {

    private final ObjectMapper objectMapper;

    public PersonMapper(){
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Person> dtoListToEntityList(List<PersonDTO> dto) {
        return dto.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO entityToDto(Person person) {
        return this.objectMapper.convertValue(person, PersonDTO.class);
    }

    @Override
    public Person dtoToEntity(PersonDTO personDTO) {
        return this.objectMapper.convertValue(personDTO, Person.class);
    }
}

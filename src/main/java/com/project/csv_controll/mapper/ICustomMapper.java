package com.project.csv_controll.mapper;

import java.util.List;

public interface ICustomMapper<Dto, Entity> {

    List<Entity> dtoListToEntityList(List<Dto> dto);
    Dto entityToDto(Entity entity);
    Entity dtoToEntity(Dto dto);
}

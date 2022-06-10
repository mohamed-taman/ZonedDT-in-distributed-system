package com.sxi.e4t.lab.fizzbus.domain.mapper;

import com.sxi.e4t.lab.fizzbus.domain.entity.Car;
import com.sxi.e4t.lab.fizzbus.domain.vo.response.CarView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "branch", source = "car.branch.name")
    @Mapping(target = "company", source = "car.branch.company.name")
    CarView toView(Car car);
}

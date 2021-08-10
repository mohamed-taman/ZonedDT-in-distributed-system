package com.sxi.e4t.lab.uber.domain.mapper;

import com.sxi.e4t.lab.uber.domain.entity.Customer;
import com.sxi.e4t.lab.uber.domain.entity.Driver;
import com.sxi.e4t.lab.uber.domain.entity.Trip;
import com.sxi.e4t.lab.uber.domain.vo.request.TripRequest;
import com.sxi.e4t.lab.uber.domain.vo.response.CustomerView;
import com.sxi.e4t.lab.uber.domain.vo.response.DriverView;
import com.sxi.e4t.lab.uber.domain.vo.response.TripResponse;
import com.sxi.e4t.lab.uber.infra.util.DateTimeParser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", imports = DateTimeParser.class)
public abstract class TripMapper {

    @Autowired
    protected CarMapper carMapper;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car.id", source = "carId")
    @Mapping(target = "driver.id", source = "driverId")
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "startOn",
            expression = "java( DateTimeParser.parseDateTime(request.startOn(), request.timezone()) )")
    @Mapping(target = "endAt",
            expression = "java( DateTimeParser.parseDateTime(request.endAt(), request.timezone()) )")
    public abstract Trip toModel(TripRequest request);

    public abstract List<Trip> toModels(List<TripRequest> request);

    @Mapping(target = "startOn",
            expression = "java( DateTimeParser.toDateTimeString(trip.getStartOn(), timezone) )")
    @Mapping(target = "endAt",
            expression = "java( DateTimeParser.toDateTimeString(trip.getEndAt(), timezone) )")
    @Mapping(target = "recordAge",
            expression = "java( DateTimeParser.calculateRecordAge(trip.getStartOn(), timezone) )")
    @Mapping(target = "car", expression = "java( carMapper.toView(trip.getCar()) )")
    public abstract TripResponse toView(Trip trip, String timezone);

    protected abstract DriverView map(Driver driver);

    protected abstract CustomerView map(Customer customer);

    public List<TripResponse> toViews(List<Trip> trips, String timezone) {
        return trips.stream().map(trip -> toView(trip, timezone)).toList();

    }

}

package com.sxi.lab.fizzbus.infra.mapper;

import com.sxi.lab.fizzbus.api.vo.request.TripRequest;
import com.sxi.lab.fizzbus.api.vo.response.CarView;
import com.sxi.lab.fizzbus.api.vo.response.CustomerView;
import com.sxi.lab.fizzbus.api.vo.response.DriverView;
import com.sxi.lab.fizzbus.api.vo.response.TripResponse;
import com.sxi.lab.fizzbus.domain.Car;
import com.sxi.lab.fizzbus.domain.Customer;
import com.sxi.lab.fizzbus.domain.Driver;
import com.sxi.lab.fizzbus.domain.Trip;
import com.sxi.lab.fizzbus.infra.util.DateTimeUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", imports = DateTimeUtil.class)
public interface TripMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car.id", source = "carId")
    @Mapping(target = "driver.id", source = "driverId")
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "startOn",
            expression = "java( DateTimeUtil.parseDateTime(request.startOn(), request.timezone()) )")
    @Mapping(target = "endAt",
            expression = "java( DateTimeUtil.parseDateTime(request.endAt(), request.timezone()) )")
    Trip toModel(TripRequest request);

    List<Trip> toModels(List<TripRequest> request);

    @Mapping(target = "startOn",
            expression = "java( DateTimeUtil.toString(trip.getStartOn(), timezone) )")
    @Mapping(target = "endAt",
            expression = "java( DateTimeUtil.toString(trip.getEndAt(), timezone) )")
    @Mapping(target = "recordAge",
            expression = "java( DateTimeUtil.calculateRecordAge(trip.getStartOn(), timezone) )")
    TripResponse toView(Trip trip, String timezone);

    default List<TripResponse> toViews(List<Trip> trips, String timezone) {
        return trips.stream().map(trip -> toView(trip, timezone)).toList();
    }

    DriverView map(Driver driver);

    CustomerView map(Customer customer);

    @Mapping(target = "branch", source = "car.branch.name")
    @Mapping(target = "company", source = "car.branch.company.name")
    CarView map(Car car);

}

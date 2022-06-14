package com.sxi.lab.fizzbus.service;

import com.sxi.lab.fizzbus.domain.entity.Trip;
import com.sxi.lab.fizzbus.domain.mapper.TripMapper;
import com.sxi.lab.fizzbus.domain.vo.request.TripRequest;
import com.sxi.lab.fizzbus.domain.vo.response.TripResponse;
import com.sxi.lab.fizzbus.infra.exception.NotFoundException;
import com.sxi.lab.fizzbus.repository.TripRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sxi.lab.fizzbus.infra.util.DateTimeParser.parseDateTime;

@Service
@Log4j2
public class TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public TripService(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Transactional(readOnly = true)
    public List<TripResponse> getAll(String timezone) {
        return tripMapper.toViews(tripRepository
                .findAll(), timezone);
    }


    public void add(TripRequest tripRequest) {

        tripRepository.save(tripMapper.toModel(tripRequest));
    }

    public void addAll(List<TripRequest> tripRequests) {
        tripRepository.saveAll(tripMapper.toModels(tripRequests));
    }

    public void update(Long id, TripRequest trip) {

        var updateTrip = tripMapper.toModel(trip);
        updateTrip.setId(id);
        tripRepository.save(updateTrip);
    }

    public void delete(Long tripId) {
        tripRepository
                .findById(tripId)
                .ifPresent(tripRepository::delete);
    }

    @Transactional(readOnly = true)
    public TripResponse findById(Long tripId, String timezone) {
        return tripRepository
                .findById(tripId)
                .map(trip -> tripMapper.toView(trip, timezone))
                .orElseThrow(() -> new NotFoundException(Trip.class, tripId));
    }

    @Transactional(readOnly = true)
    public List<TripResponse> findBetween(String fromDate, String toDate, String timezone) {
        return tripMapper.toViews(tripRepository
                .findAllByStartOnIsBetween(
                        parseDateTime(fromDate, timezone),
                        parseDateTime(toDate, timezone)), timezone);
    }

}

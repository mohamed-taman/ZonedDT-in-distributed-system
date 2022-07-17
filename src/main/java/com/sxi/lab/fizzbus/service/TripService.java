package com.sxi.lab.fizzbus.service;

import com.sxi.lab.fizzbus.api.vo.request.TripRequest;
import com.sxi.lab.fizzbus.api.vo.response.TripResponse;
import com.sxi.lab.fizzbus.domain.Trip;
import com.sxi.lab.fizzbus.infra.exception.NotFoundException;
import com.sxi.lab.fizzbus.infra.mapper.TripMapper;
import com.sxi.lab.fizzbus.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sxi.lab.fizzbus.infra.util.DateTimeUtil.parseDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    @Transactional(readOnly = true)
    public List<TripResponse> getAll(String timezone) {
        return tripMapper.toViews(tripRepository
                .findAll(), timezone);
    }

    public long add(TripRequest tripRequest) {
        return tripRepository.save(tripMapper.toModel(tripRequest)).getId();
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

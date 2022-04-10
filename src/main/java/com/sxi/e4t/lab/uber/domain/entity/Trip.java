package com.sxi.e4t.lab.uber.domain.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.ZonedDateTime;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "TRIP")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "TIMEZONE")
    private String timezone;

    @Basic
    @Column(name = "START_ON")
    private ZonedDateTime startOn;

    @Basic
    @Column(name = "END_AT")
    private ZonedDateTime endAt;

    @Basic
    @Column(name = "DISTANCE")
    private double distance;

    @Basic
    @Column(name = "STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    @ToString.Exclude
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID")
    @ToString.Exclude
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    @ToString.Exclude
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var trip = (Trip) o;

        return Objects.equals(id, trip.id) ||
                (startOn.isEqual(trip.startOn) &&
                        endAt.isEqual(trip.endAt) &&
                        customer.equals(trip.customer));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTimezone(), getStartOn(), getEndAt(),
                getDistance(), getStatus(), getCar(), getDriver(), getCustomer());
    }
}

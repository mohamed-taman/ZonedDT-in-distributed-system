package com.sxi.e4t.lab.uber.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


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

        return Objects.equals(id, trip.id);
    }

    @Override
    public int hashCode() {
        return 149555212;
    }
}

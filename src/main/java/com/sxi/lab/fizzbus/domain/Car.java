package com.sxi.lab.fizzbus.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CAR")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "MODEL")
    private String model;

    @NaturalId
    @Column(name = "CHASSIS_NUMBER")
    private String chassisNumber;

    @Basic
    @Column(name = "COLOR")
    private String color;

    @Basic
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    @ToString.Exclude
    private Branch branch;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Trip> trips = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var car = (Car) o;

        return Objects.equals(id, car.id) || Objects.equals(chassisNumber, car.chassisNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getChassisNumber(), getColor(),
                getRegistrationNumber(), getBranch(), getTrips());
    }
}

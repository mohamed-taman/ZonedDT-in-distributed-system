package com.sxi.e4t.lab.uber.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import jakarta.persistence.*;
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

        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return 2133657150;
    }
}

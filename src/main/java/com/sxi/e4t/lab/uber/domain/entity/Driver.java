package com.sxi.e4t.lab.uber.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DRIVER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "LICENSE_NUMBER")
    private String licenseNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Trip> trips = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var driver = (Driver) o;

        return Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return 1858918620;
    }
}

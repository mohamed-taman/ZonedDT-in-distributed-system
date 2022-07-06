package com.sxi.lab.fizzbus.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COMPANY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "TIMEZONE")
    private String timezone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Branch> branches = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var company = (Company) o;

        return Objects.equals(id, company.id) || Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTimezone(), getBranches());
    }
}

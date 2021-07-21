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
@Table(name = "BRANCH")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Branch {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    @ToString.Exclude
    private Company company;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Car> cars = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var branch = (Branch) o;

        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return 2015877924;
    }
}

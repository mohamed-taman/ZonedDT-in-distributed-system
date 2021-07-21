package com.sxi.e4t.lab.uber.repository;

import com.sxi.e4t.lab.uber.domain.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
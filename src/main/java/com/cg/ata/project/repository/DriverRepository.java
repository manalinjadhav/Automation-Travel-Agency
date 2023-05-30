package com.cg.ata.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ata.project.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

	Optional<Driver> findBydriverName(String driverName);

}

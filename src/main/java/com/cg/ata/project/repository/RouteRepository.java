package com.cg.ata.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ata.project.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

	Optional<Route> findByDistination(String distination);

}

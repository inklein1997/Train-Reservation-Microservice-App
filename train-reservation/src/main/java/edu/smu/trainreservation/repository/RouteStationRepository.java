package edu.smu.trainreservation.repository;

import edu.smu.trainreservation.dto.RouteStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStationRepository extends JpaRepository<RouteStation, Integer> {
}

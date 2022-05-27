package edu.smu.trainreservation.repository;

import edu.smu.trainreservation.dto.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

}

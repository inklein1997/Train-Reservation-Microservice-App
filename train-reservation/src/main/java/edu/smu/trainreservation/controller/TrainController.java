package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.Train;
import edu.smu.trainreservation.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RefreshScope
public class TrainController {
    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/trains")
    @ResponseStatus(HttpStatus.OK)
    public List<Train> getAllTrains() {
        return serviceLayer.getAllTrains();
    }

    @GetMapping("/trains/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Train> getTrainById(@PathVariable Integer id) {
        return serviceLayer.getTrainById(id);
    }

    @PostMapping("/trains")
    @ResponseStatus(HttpStatus.CREATED)
    public Train addTrain(@RequestBody Train train) {
        return serviceLayer.createTrain(train);
    }

    @PutMapping("/trains/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrain(@RequestBody Train train, @PathVariable Integer id) {
        if (id.equals(train.getTrainId())) {
            serviceLayer.updateTrain(train);
        }
        if (train.getTrainId().equals(null)) {
            train.setTrainId(id);
            serviceLayer.updateTrain(train);
        }
    }

    @DeleteMapping("/trains/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrain(@PathVariable Integer id) {
        serviceLayer.deleteTrain(id);
    }
}

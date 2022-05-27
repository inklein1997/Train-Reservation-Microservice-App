package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.Station;
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
public class StationController {
    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/stations")
    @ResponseStatus(HttpStatus.OK)
    public List<Station> getAllStations() {
        return serviceLayer.getAllStations();
    }

    @GetMapping("/stations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Station> getStationById(@PathVariable Integer id) {
        return serviceLayer.getStationById(id);
    }

    @PostMapping("/stations")
    @ResponseStatus(HttpStatus.CREATED)
    public Station addStation(@RequestBody Station station) {
        return serviceLayer.createStation(station);
    }

    @PutMapping("/stations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStation(@RequestBody Station station, @PathVariable Integer id) {
        if (id.equals(station.getStationId())) {
            serviceLayer.updateStation(station);
        }
        if (station.getStationId().equals(null)) {
            station.setStationId(id);
            serviceLayer.updateStation(station);
        }
    }

    @DeleteMapping("/stations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStation(@PathVariable Integer id) {
        serviceLayer.deleteStation(id);
    }
}

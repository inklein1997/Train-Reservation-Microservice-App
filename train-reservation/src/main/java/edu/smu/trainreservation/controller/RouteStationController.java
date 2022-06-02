package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.RouteStation;
import edu.smu.trainreservation.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
public class RouteStationController {
    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/routeStations")
    @ResponseStatus(HttpStatus.OK)
    public List<RouteStation> getAllRouteStations() {
        return serviceLayer.getAllRouteStations();
    }

    @GetMapping("/routeStations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<RouteStation> getRouteStationById(@PathVariable Integer id) {
        return serviceLayer.getRouteStationById(id);
    }

    @PostMapping("/routeStations")
    @ResponseStatus(HttpStatus.CREATED)
    public RouteStation addRouteStation(@RequestBody RouteStation routeStations) {
        return serviceLayer.createRouteStation(routeStations);
    }

    @PutMapping("/routeStations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRouteStation(@RequestBody RouteStation routeStations, @PathVariable Integer id) {
        if (id.equals(routeStations.getRouteStationId())) {
            serviceLayer.updateRouteStation(routeStations);
        }
        if (routeStations.getRouteStationId().equals(null)) {
            routeStations.setRouteStationId(id);
            serviceLayer.updateRouteStation(routeStations);
        }
    }

    @DeleteMapping("/routeStations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRouteStation(@PathVariable Integer id) {
        serviceLayer.deleteRouteStation(id);
    }
}

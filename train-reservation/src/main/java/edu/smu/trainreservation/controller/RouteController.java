package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.Route;
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
public class RouteController {
    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/routes")
    @ResponseStatus(HttpStatus.OK)
    public List<Route> getAllRoutes() {
        return serviceLayer.getAllRoutes();
    }

    @GetMapping("/routes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Route> getRouteById(@PathVariable Integer id) {
        return serviceLayer.getRouteById(id);
    }

    @PostMapping("/routes")
    @ResponseStatus(HttpStatus.CREATED)
    public Route addRoute(@RequestBody Route route) {
        return serviceLayer.createRoute(route);
    }

    @PutMapping("/routes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoute(@RequestBody Route route, @PathVariable Integer id) {
        if (id.equals(route.getRouteId())) {
            serviceLayer.updateRoute(route);
        }
        if (route.getRouteId().equals(null)) {
            route.setRouteId(id);
            serviceLayer.updateRoute(route);
        }
    }

    @DeleteMapping("/routes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoute(@PathVariable Integer id) {
        serviceLayer.deleteRoute(id);
    }
}

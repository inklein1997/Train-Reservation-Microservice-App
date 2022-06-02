package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.*;
import edu.smu.trainreservation.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RefreshScope
public class DataLoader {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/seed")
    @ResponseStatus(HttpStatus.CREATED)
    public String seedDatabase() {
        serviceLayer.clearDatabase();

        serviceLayer.createCustomer(new Customer(1, "Gary", "Coleman", "gcoleman@somewhere.com","password","123.456.7890"));
        serviceLayer.createTrain(new Train(1, "California Zephyr", "Dash 8-32BWH", "GE", "2015", 250, "2A", "Diesel"));
        serviceLayer.createStation(new Station(4, "Sacramento, CA", "SAC"));
        serviceLayer.createStation(new Station(5, "Davis, CA", "DAV"));
        serviceLayer.createStation(new Station(6, "Fairfield-Vacaville", "FFV"));
        serviceLayer.createTicket(new Ticket(1,1, "Gary", 13, 10,40.00, new Date(), "5A"));
        serviceLayer.createRoute(new Route(1,"Capitol Corridor",1,18,4));
        serviceLayer.createRouteStation(new RouteStation(1,6, new Date(), new Date()));
        serviceLayer.createRouteStation(new RouteStation(1,5, new Date(), new Date()));
        serviceLayer.createRouteStation(new RouteStation(1,4, new Date(), new Date()));

        return "Data has been seeded";
    }
}

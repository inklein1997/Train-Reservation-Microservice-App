package edu.smu.trainreservation.service;

import edu.smu.trainreservation.dto.*;
import edu.smu.trainreservation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {

    private CustomerRepository customerRepository;
    private RouteRepository routeRepository;
    private RouteStationRepository routeStationRepository;
    private StationRepository stationRepository;
    private TicketRepository ticketRepository;
    private TrainRepository trainRepository;

    @Autowired
    public ServiceLayer(CustomerRepository customerRepository, RouteRepository routeRepository, RouteStationRepository routeStationRepository, StationRepository stationRepository, TicketRepository ticketRepository, TrainRepository trainRepository) {
        this.customerRepository = customerRepository;
        this.routeRepository = routeRepository;
        this.routeStationRepository = routeStationRepository;
        this.stationRepository = stationRepository;
        this.ticketRepository = ticketRepository;
        this.trainRepository = trainRepository;
    }

    // READ METHODS

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
    public List<RouteStation> getAllRouteStations() {
        return routeStationRepository.findAll();
    }
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
    public Optional<Route> getRouteById(Integer id) {
        return routeRepository.findById(id);
    }
    public Optional<RouteStation> getRouteStationById(Integer id) {
        return routeStationRepository.findById(id);
    }
    public Optional<Station> getStationById(Integer id) {
        return stationRepository.findById(id);
    }
    public Optional<Ticket> getTicketById(Integer id) {
        return ticketRepository.findById(id);
    }
    public Optional<Train> getTrainById(Integer id) {
        return trainRepository.findById(id);
    }

    // CREATE METHODS
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }
    public RouteStation createRouteStation(RouteStation routeStation) {
        return routeStationRepository.save(routeStation);
    }
    public Station createStation(Station station) {
        return stationRepository.save(station);
    }
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    public Train createTrain(Train train) {
        return trainRepository.save(train);
    }

    // UPDATE METHODS
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void updateRoute(Route route) {
        routeRepository.save(route);
    }
    public void updateRouteStation(RouteStation routeStation) {
        routeStationRepository.save(routeStation);
    }
    public void updateStation(Station station) {
        stationRepository.save(station);
    }
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }
    public void updateTrain(Train train) {
        trainRepository.save(train);
    }

    // DELETE METHODS
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
    public void deleteRoute(Integer id) {
        routeRepository.deleteById(id);
    }
    public void deleteRouteStation(Integer id) {
        routeStationRepository.deleteById(id);
    }
    public void deleteStation(Integer id) {
        stationRepository.deleteById(id);
    }
    public void deleteTicket(Integer id) {
        ticketRepository.deleteById(id);
    }
    public void deleteTrain(Integer id) {
        trainRepository.deleteById(id);
    }

}

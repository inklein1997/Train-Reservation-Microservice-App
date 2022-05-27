package edu.smu.trainreservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "route_id")
    @OneToOne(mappedBy = "route")
    private Integer routeId;

    @Column(name = "customer_id")
    @OneToOne(mappedBy = "route")
    private Integer customerId;

    @Column(name = "first_name")
    @OneToOne(mappedBy = "firstName")
    private String firstName;

    @Column(name = "source_station_id")
    @OneToOne(mappedBy = "station")
    private Integer sourceStationId;

    @Column(name = "destination_station_id")
    @OneToOne(mappedBy = "station")
    private Integer destinationStationId;

    private double price;

    private Date ticketDate;

    @Column(name = "seat_no")
    private String seatNo;
}

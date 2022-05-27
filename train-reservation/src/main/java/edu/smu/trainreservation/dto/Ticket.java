package edu.smu.trainreservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "source_station_id")
    private Integer sourceStationId;

    @Column(name = "destination_station_id")
    private Integer destinationStationId;

    private double price;

    private Date ticketDate;

    @Column(name = "seat_no")
    private String seatNo;

    public Ticket() {
    }

    public Ticket(Integer routeId, Integer customerId, String firstName, Integer sourceStationId, Integer destinationStationId, double price, Date ticketDate, String seatNo) {
        this.routeId = routeId;
        this.customerId = customerId;
        this.firstName = firstName;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
        this.price = price;
        this.ticketDate = ticketDate;
        this.seatNo = seatNo;
    }

    public Ticket(Integer ticketId, Integer routeId, Integer customerId, String firstName, Integer sourceStationId, Integer destinationStationId, double price, Date ticketDate, String seatNo) {
        this.ticketId = ticketId;
        this.routeId = routeId;
        this.customerId = customerId;
        this.firstName = firstName;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
        this.price = price;
        this.ticketDate = ticketDate;
        this.seatNo = seatNo;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getSourceStationId() {
        return sourceStationId;
    }

    public void setSourceStationId(Integer sourceStationId) {
        this.sourceStationId = sourceStationId;
    }

    public Integer getDestinationStationId() {
        return destinationStationId;
    }

    public void setDestinationStationId(Integer destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 && Objects.equals(ticketId, ticket.ticketId) && Objects.equals(routeId, ticket.routeId) && Objects.equals(customerId, ticket.customerId) && Objects.equals(firstName, ticket.firstName) && Objects.equals(sourceStationId, ticket.sourceStationId) && Objects.equals(destinationStationId, ticket.destinationStationId) && Objects.equals(ticketDate, ticket.ticketDate) && Objects.equals(seatNo, ticket.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, routeId, customerId, firstName, sourceStationId, destinationStationId, price, ticketDate, seatNo);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", routeId=" + routeId +
                ", customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", sourceStationId=" + sourceStationId +
                ", destinationStationId=" + destinationStationId +
                ", price=" + price +
                ", ticketDate=" + ticketDate +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}

package edu.smu.trainreservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "route_station")
public class RouteStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_station_id")
    private Integer routeStationId;

    @Column(name = "route_id")
    private Integer ticketId;

    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "scheduled_arrival")
    @DateTimeFormat(pattern = "HH:MM:SS")
    private Date scheduledArrival;

    @Column(name = "scheduled_departure")
    @DateTimeFormat(pattern = "HH:MM:SS")
    private Date scheduledDeparture;

    public RouteStation() {
    }

    public RouteStation(Integer routeStationId, Integer ticketId, Integer stationId, Date scheduledArrival, Date scheduledDeparture) {
        this.routeStationId = routeStationId;
        this.ticketId = ticketId;
        this.stationId = stationId;
        this.scheduledArrival = scheduledArrival;
        this.scheduledDeparture = scheduledDeparture;
    }

    public RouteStation(Integer ticketId, Integer stationId, Date scheduledArrival, Date scheduledDeparture) {
        this.ticketId = ticketId;
        this.stationId = stationId;
        this.scheduledArrival = scheduledArrival;
        this.scheduledDeparture = scheduledDeparture;
    }

    public Integer getRouteStationId() {
        return routeStationId;
    }

    public void setRouteStationId(Integer routeStationId) {
        this.routeStationId = routeStationId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Date getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(Date scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public Date getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(Date scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStation that = (RouteStation) o;
        return Objects.equals(routeStationId, that.routeStationId) && Objects.equals(ticketId, that.ticketId) && Objects.equals(stationId, that.stationId) && Objects.equals(scheduledArrival, that.scheduledArrival) && Objects.equals(scheduledDeparture, that.scheduledDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeStationId, ticketId, stationId, scheduledArrival, scheduledDeparture);
    }

    @Override
    public String toString() {
        return "RouteStation{" +
                "routeStationId=" + routeStationId +
                ", ticketId=" + ticketId +
                ", stationId=" + stationId +
                ", scheduledArrival=" + scheduledArrival +
                ", scheduledDeparture=" + scheduledDeparture +
                '}';
    }
}

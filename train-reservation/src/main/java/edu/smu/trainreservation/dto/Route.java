package edu.smu.trainreservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Integer routeId;
    @Column(name = "route_name")
    private String routeName;
    @Column(name = "train_id")
    private Integer trainId;
    @Column(name = "source_station_id")
    private Integer sourceStationId;
    @Column(name = "destination_station_id")
    private Integer destinationStationId;

    public Route() {
    }

    public Route(Integer routeId, String routeName, Integer trainId, Integer sourceStationId, Integer destinationStationId) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.trainId = trainId;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
    }

    public Route(String routeName, Integer trainId, Integer sourceStationId, Integer destinationStationId) {
        this.routeName = routeName;
        this.trainId = trainId;
        this.sourceStationId = sourceStationId;
        this.destinationStationId = destinationStationId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(routeId, route.routeId) && Objects.equals(routeName, route.routeName) && Objects.equals(trainId, route.trainId) && Objects.equals(sourceStationId, route.sourceStationId) && Objects.equals(destinationStationId, route.destinationStationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, routeName, trainId, sourceStationId, destinationStationId);
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", routeName='" + routeName + '\'' +
                ", trainId=" + trainId +
                ", sourceStationId=" + sourceStationId +
                ", destinationStationId=" + destinationStationId +
                '}';
    }
}

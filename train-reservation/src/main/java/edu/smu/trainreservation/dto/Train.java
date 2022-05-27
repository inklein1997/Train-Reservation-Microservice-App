package edu.smu.trainreservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_id")
    private Integer train_id;
    private String name;
    private String model;
    private String manufacturer;
    private String year;
    @Column(name = "total_seats")
    private String totalSeats;
    @Column(name = "seat_layout")
    private String seatLayout;
    @Column(name = "power_type")
    private String powerType;

    public Train() {
    }

    public Train(Integer train_id, String name, String model, String manufacturer, String year, String totalSeats, String seatLayout, String powerType) {
        this.train_id = train_id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.totalSeats = totalSeats;
        this.seatLayout = seatLayout;
        this.powerType = powerType;
    }

    public Train(String name, String model, String manufacturer, String year, String totalSeats, String seatLayout, String powerType) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.totalSeats = totalSeats;
        this.seatLayout = seatLayout;
        this.powerType = powerType;
    }

    public Integer getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Integer train_id) {
        this.train_id = train_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(train_id, train.train_id) && Objects.equals(name, train.name) && Objects.equals(model, train.model) && Objects.equals(manufacturer, train.manufacturer) && Objects.equals(year, train.year) && Objects.equals(totalSeats, train.totalSeats) && Objects.equals(seatLayout, train.seatLayout) && Objects.equals(powerType, train.powerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(train_id, name, model, manufacturer, year, totalSeats, seatLayout, powerType);
    }

    @Override
    public String toString() {
        return "Train{" +
                "train_id=" + train_id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year='" + year + '\'' +
                ", totalSeats='" + totalSeats + '\'' +
                ", seatLayout='" + seatLayout + '\'' +
                ", powerType='" + powerType + '\'' +
                '}';
    }
}

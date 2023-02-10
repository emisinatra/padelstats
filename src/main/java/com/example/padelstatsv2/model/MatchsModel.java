package com.example.padelstatsv2.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="matchs")
public class MatchsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String place;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchsModel that = (MatchsModel) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, place);
    }

    @Override
    public String toString() {
        return "MatchsModel{" +
                "id=" + id +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }

}

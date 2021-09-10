package com.reviakin_package.dist_api.models.entity.city;

import com.reviakin_package.dist_api.models.entity.city.base.City;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@Table(name = "cities")
@XmlType(propOrder = {
        "name", "latitude", "longtitude"
})
public class CommonCity implements City, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longtitude")
    private float longtitude;

    public CommonCity(){

    }

    public CommonCity(String name, float latitude, float longtitude) {
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }
}

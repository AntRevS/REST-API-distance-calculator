package com.reviakin_package.dist_api.models.entity.distance;

import com.reviakin_package.dist_api.models.entity.distance.base.Distance;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@Table(name = "distance")
@XmlType(propOrder = {
        "fromCity", "forCity", "distance"
})
public class CommonDistance implements Distance, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "for_city")
    private String forCity;

    @Column(name = "dist")
    private float distance;

    public CommonDistance() {

    }

    public CommonDistance(String fromCity, String forCity, float distance) {
        this.fromCity = fromCity;
        this.forCity = forCity;
        this.distance = distance;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getForCity() {
        return forCity;
    }

    public void setForCity(String forCity) {
        this.forCity = forCity;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}

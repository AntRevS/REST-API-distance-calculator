package com.reviakin_package.dist_api.models.usecase.distance.result;

import com.reviakin_package.dist_api.models.entity.distance.CommonDistance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "result")

@XmlType(propOrder = {
        "distance", "calculationType"
})
public class FindDistResult{

    private String calculationType;
    private CommonDistance distance;

    public String getCalculationType() {
        return calculationType;
    }

    @XmlElement(name = "distance")
    public CommonDistance getDistance() {
        return distance;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public void setDistance(CommonDistance distance) {
        this.distance = distance;
    }
}

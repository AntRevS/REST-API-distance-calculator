package com.reviakin_package.dist_api.models.entity.distance;

import com.reviakin_package.dist_api.models.entity.distance.CommonDistance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "distances")
public class Distances {

    private List<CommonDistance> distanceList;

    @XmlElement(name = "distance")
    public List<CommonDistance> getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(List<CommonDistance> distanceList) {
        this.distanceList = distanceList;
    }
}

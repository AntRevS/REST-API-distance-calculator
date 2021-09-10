package com.reviakin_package.dist_api.models.entity.city;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cities")
public class Cities {

    private List<CommonCity> citiesList;

    @XmlElement(name = "city")
    public List<CommonCity> getCitiesList(){
        return citiesList;
    }

    public void setCitiesList(List<CommonCity> citiesList){
        this.citiesList = citiesList;
    }
}

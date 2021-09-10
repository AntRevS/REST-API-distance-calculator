package com.reviakin_package.dist_api.models.usecase.distance;

import com.reviakin_package.dist_api.Util.CalculationType;
import com.reviakin_package.dist_api.models.entity.city.CommonCity;
import com.reviakin_package.dist_api.models.entity.distance.CommonDistance;
import com.reviakin_package.dist_api.models.usecase.distance.base.DistUseCase;
import com.reviakin_package.dist_api.repository.CityRepository;
import com.reviakin_package.dist_api.repository.DistanceRepository;
import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;

public class CalculateDistUseCase implements DistUseCase {

    private CityRepository cityRepository;
    private DistanceRepository distanceRepository;
    private CommonCity cityFrom;
    private CommonCity cityFor;

    private final double pi = 3.14;

    public CalculateDistUseCase(
            DistanceRepository distanceRepository,
            CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;
    }

    @Override
    public FindDistResult buildCase(String fromCity, String forCity){
        cityFrom = cityRepository.findByName(fromCity);
        cityFor = cityRepository.findByName(forCity);

        double ph1 = Math.toRadians(cityFrom.getLatitude());
        double ph2 = Math.toRadians(cityFor.getLatitude());

        double l1 = Math.toRadians(cityFrom.getLongtitude());
        double l2 = Math.toRadians(cityFor.getLongtitude());

        double delyg = Math.acos(Math.sin(ph1) * Math.sin(ph2) + Math.cos(ph1) * Math.cos(ph2) * Math.cos(l1 - l2));

        int r = 6371;

        double d= 6371 * delyg;

        CommonDistance distance = new CommonDistance(fromCity, forCity, (((Double) d).floatValue()));

        FindDistResult result = new FindDistResult();
        result.setCalculationType(CalculationType.CROWFLIGHT.getTitle());
        result.setDistance(distance);

        if(!(distanceRepository.existsByFromCityAndForCity(fromCity, forCity) ||
                distanceRepository.existsByFromCityAndForCity(forCity, fromCity))
        ){
            distanceRepository.save(distance);
        }

        return result;
    }
}

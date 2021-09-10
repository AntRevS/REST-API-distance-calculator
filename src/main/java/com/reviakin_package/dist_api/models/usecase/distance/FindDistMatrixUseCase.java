package com.reviakin_package.dist_api.models.usecase.distance;

import com.reviakin_package.dist_api.Util.CalculationType;
import com.reviakin_package.dist_api.models.entity.city.CommonCity;
import com.reviakin_package.dist_api.models.entity.distance.CommonDistance;
import com.reviakin_package.dist_api.models.usecase.distance.base.DistUseCase;
import com.reviakin_package.dist_api.repository.CityRepository;
import com.reviakin_package.dist_api.repository.DistanceRepository;
import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;

public class FindDistMatrixUseCase implements DistUseCase {

    private DistanceRepository distanceRepository;
    private CityRepository cityRepository;

    private CommonCity cityFrom;
    private CommonCity cityFor;

    public FindDistMatrixUseCase(
            DistanceRepository distanceRepository,
            CityRepository cityRepository){
        this.distanceRepository = distanceRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public FindDistResult buildCase(String fromCity, String forCity){
        cityFrom = cityRepository.findByName(fromCity);
        cityFor = cityRepository.findByName(forCity);
        CommonDistance distance = distanceRepository.findByNames(fromCity, forCity);

        if(distance != null){
            FindDistResult result = new FindDistResult();
            result.setCalculationType(CalculationType.MATRIX.getTitle());
            result.setDistance(distance);

            return result;
        }

        return null;
    }
}

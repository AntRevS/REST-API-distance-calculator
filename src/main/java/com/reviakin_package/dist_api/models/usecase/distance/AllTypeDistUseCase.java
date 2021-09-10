package com.reviakin_package.dist_api.models.usecase.distance;

import com.reviakin_package.dist_api.models.usecase.distance.base.DistUseCase;
import com.reviakin_package.dist_api.repository.CityRepository;
import com.reviakin_package.dist_api.repository.DistanceRepository;
import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;

public class AllTypeDistUseCase implements DistUseCase {

    private CityRepository cityRepository;
    private DistanceRepository distanceRepository;

    public AllTypeDistUseCase(
            DistanceRepository distanceRepository,
            CityRepository cityRepository
    ){
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;
    }

    @Override
    public FindDistResult buildCase(String fromCity, String forCity){
        FindDistResult matrixResult = new FindDistMatrixUseCase(
                distanceRepository, cityRepository)
                .buildCase(fromCity, forCity);
        if(matrixResult != null){
            return matrixResult;
        }
        return new CalculateDistUseCase(distanceRepository, cityRepository)
                .buildCase(fromCity, forCity);
    }
}

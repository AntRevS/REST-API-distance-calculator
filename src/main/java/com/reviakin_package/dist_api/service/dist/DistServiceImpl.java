package com.reviakin_package.dist_api.service.dist;

import com.reviakin_package.dist_api.models.usecase.distance.AllTypeDistUseCase;
import com.reviakin_package.dist_api.models.usecase.distance.CalculateDistUseCase;
import com.reviakin_package.dist_api.models.usecase.distance.FindDistMatrixUseCase;
import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;
import com.reviakin_package.dist_api.repository.CityRepository;
import com.reviakin_package.dist_api.repository.DistanceRepository;
import com.reviakin_package.dist_api.service.dist.base.DistService;
import org.springframework.stereotype.Service;

@Service
public class DistServiceImpl implements DistService {

    private DistanceRepository distanceRepository;
    private CityRepository cityRepository;

    public DistServiceImpl(DistanceRepository distanceRepository, CityRepository cityRepository) {
        this.distanceRepository = distanceRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public FindDistResult findCrowflight(String cityFrom, String cityFor) {
        return new CalculateDistUseCase(distanceRepository, cityRepository)
                .buildCase(cityFrom, cityFor);
    }

    @Override
    public FindDistResult findMatrix(String cityFrom, String cityFor) {
        return new FindDistMatrixUseCase(distanceRepository, cityRepository)
                .buildCase(cityFrom, cityFor);
    }

    @Override
    public FindDistResult findAllType(String cityFrom, String cityFor) {
        return new AllTypeDistUseCase(distanceRepository, cityRepository)
                .buildCase(cityFrom, cityFor);
    }
}

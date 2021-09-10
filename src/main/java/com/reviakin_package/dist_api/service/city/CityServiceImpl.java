package com.reviakin_package.dist_api.service.city;

import com.reviakin_package.dist_api.models.entity.city.Cities;
import com.reviakin_package.dist_api.repository.CityRepository;
import com.reviakin_package.dist_api.service.city.base.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cities getAllCities() {
        Cities cities = new Cities();
        cities.setCitiesList(repository.findAll());
        return cities;
    }
}

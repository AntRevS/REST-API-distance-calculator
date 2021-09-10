package com.reviakin_package.dist_api.repository;

import com.reviakin_package.dist_api.models.entity.city.CommonCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CityRepository extends JpaRepository<CommonCity, Long>{

    CommonCity findByName(String name);

}

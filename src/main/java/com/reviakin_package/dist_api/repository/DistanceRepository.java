package com.reviakin_package.dist_api.repository;

import com.reviakin_package.dist_api.models.entity.distance.CommonDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface DistanceRepository extends JpaRepository<CommonDistance, Long> {

    @Query("Select d FROM CommonDistance d WHERE d.fromCity = :fromCity and d.forCity = :forCity")
    CommonDistance findByNames(String fromCity, String forCity);

    Boolean existsByFromCityAndForCity(String fromCity, String forCity);

}

package com.reviakin_package.dist_api.models.usecase.distance.base;

import com.reviakin_package.dist_api.models.usecase.base.UseCase;
import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;

public interface DistUseCase extends UseCase {

    FindDistResult buildCase(String fromCity, String forCity);

}

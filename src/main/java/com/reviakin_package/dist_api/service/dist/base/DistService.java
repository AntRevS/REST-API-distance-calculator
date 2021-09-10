package com.reviakin_package.dist_api.service.dist.base;

import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;

public interface DistService {

    FindDistResult findCrowflight(String cityFrom, String cityFor);

    FindDistResult findMatrix(String cityFrom, String cityFor);

    FindDistResult findAllType(String cityFrom, String cityFor);
}

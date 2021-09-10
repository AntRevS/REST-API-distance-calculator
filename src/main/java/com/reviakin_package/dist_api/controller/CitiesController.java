package com.reviakin_package.dist_api.controller;

import com.reviakin_package.dist_api.Util.CalculationType;
import com.reviakin_package.dist_api.models.entity.city.Cities;
import com.reviakin_package.dist_api.models.entity.response.SignalResponse;
import com.reviakin_package.dist_api.models.usecase.distance.result.FindDistResult;
import com.reviakin_package.dist_api.service.city.CityServiceImpl;
import com.reviakin_package.dist_api.service.city.base.CityService;
import com.reviakin_package.dist_api.service.dist.base.DistService;
import com.reviakin_package.dist_api.service.dist.DistServiceImpl;
import com.reviakin_package.dist_api.service.upload.base.UploadService;
import com.reviakin_package.dist_api.service.upload.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static com.reviakin_package.dist_api.Util.Constants.*;

@RestController
@RequestMapping("/api/v1/cities")
public class CitiesController {

    private DistService distService;
    private UploadService uploadCitiesService;
    private CityService cityService;

    @Autowired
    public CitiesController(
            DistServiceImpl distService,
            UploadServiceImpl uploadCitiesService,
            CityServiceImpl cityService
    ){
        this.distService = distService;
        this.uploadCitiesService = uploadCitiesService;
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public Cities showCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/calc/{type}/{fromCity}/{forCity}")
    public FindDistResult calculateDistance(
            @PathVariable String type,
            @PathVariable String fromCity,
            @PathVariable String forCity
    ){
        switch(CalculationType.getByTitle(type)){
            case CROWFLIGHT:
                return distService.findCrowflight(fromCity, forCity);
            case MATRIX:
                return distService.findMatrix(fromCity, forCity);
            case ALL:
                return distService.findAllType(fromCity, forCity);
        }
        return null;
    }

    @PostMapping(value = "/upload/cities")
    public @ResponseBody
    SignalResponse upload(
            @RequestParam("file") MultipartFile file
    ){
        if(!file.isEmpty()){
            File fileOut = uploadCitiesService.uploadCitiesFile(file);
            if(fileOut == null)
                return new SignalResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        else{
            return new SignalResponse(ERROR_STATUS, FILE_EMPTY);
        }
        return new SignalResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }

    @PostMapping(value = "/upload/distances")
    public @ResponseBody
    SignalResponse uploadDistances(
            @RequestParam("file") MultipartFile file
    ){
        if(!file.isEmpty()){
            File fileOut = uploadCitiesService.uploadDistancesFile(file);
            if(fileOut == null)
                return new SignalResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        else{
            return new SignalResponse(ERROR_STATUS, FILE_EMPTY);
        }
        return new SignalResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }

}

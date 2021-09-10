package com.reviakin_package.dist_api.service.upload;

import com.reviakin_package.dist_api.models.entity.city.Cities;
import com.reviakin_package.dist_api.models.entity.distance.Distances;
import com.reviakin_package.dist_api.models.usecase.writefile.WriteFileUseCase;
import com.reviakin_package.dist_api.repository.CityRepository;
import com.reviakin_package.dist_api.repository.DistanceRepository;
import com.reviakin_package.dist_api.service.upload.base.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    private CityRepository cityRepository;
    private DistanceRepository distanceRepository;

    private JAXBContext cityContext;
    private JAXBContext distanceContext;

    private Unmarshaller cityUnmarshaller;
    private Unmarshaller distanceUnmarshaller;

    public UploadServiceImpl(
            CityRepository cityRepository,
            DistanceRepository distanceRepository
    ) throws JAXBException {
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;

        cityContext = JAXBContext.newInstance(Cities.class);
        distanceContext = JAXBContext.newInstance(Distances.class);

        cityUnmarshaller = cityContext.createUnmarshaller();
        distanceUnmarshaller = distanceContext.createUnmarshaller();
    }

    @Override
    public File uploadCitiesFile(MultipartFile fileIn) {
        File fileOut = new File(fileIn.getName());
        try{
            new WriteFileUseCase().buildCase(fileOut, fileIn);
            Cities cities = (Cities) cityUnmarshaller.unmarshal(fileOut);
            cityRepository.saveAll(cities.getCitiesList());
        }catch (IOException | JAXBException e){
            return null;
        }
        return fileOut;
    }

    @Override
    public File uploadDistancesFile(MultipartFile fileIn) {
        File fileOut = new File(fileIn.getName());
        try{
            new WriteFileUseCase().buildCase(fileOut, fileIn);
            Distances distances = (Distances) distanceUnmarshaller.unmarshal(fileOut);
            distanceRepository.saveAll(distances.getDistanceList());
        }catch (IOException | JAXBException e){
            return null;
        }
        return fileOut;
    }
}

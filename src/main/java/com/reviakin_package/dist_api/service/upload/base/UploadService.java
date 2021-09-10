package com.reviakin_package.dist_api.service.upload.base;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {

    File uploadCitiesFile(MultipartFile fileIn);

    File uploadDistancesFile(MultipartFile fileIn);

}

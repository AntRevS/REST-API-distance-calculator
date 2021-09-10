package com.reviakin_package.dist_api.models.usecase.writefile.base;

import com.reviakin_package.dist_api.models.usecase.base.UseCase;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface WriteUseCase extends UseCase {

    void buildCase(File fileOut, MultipartFile fileIn) throws IOException;

}

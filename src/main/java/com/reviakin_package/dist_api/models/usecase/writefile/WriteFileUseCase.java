package com.reviakin_package.dist_api.models.usecase.writefile;

import com.reviakin_package.dist_api.models.usecase.writefile.base.WriteUseCase;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileUseCase implements WriteUseCase {

    @Override
    public void buildCase(File fileOut, MultipartFile fileIn) throws IOException{
        byte[] bytes = fileIn.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(fileOut));
        stream.write(bytes);
        stream.close();
    }
}

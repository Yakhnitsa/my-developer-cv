package com.yurets_y.mydevelopercv.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ResourceService {

    @Value("${application.resource-path}")
    private String resourcePath;

    public Resource getCvFile(String language, String fileExtension) throws FileNotFoundException {
        String filePath = String.format("%s/cv.%s",language,fileExtension);
        try {
            Path file = Paths.get(resourcePath,filePath);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new FileNotFoundException(
                        "Could not read file: " + filePath);

            }
        }
        catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filePath);
        }
    }

    public String getContentType(String filePath){
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
        switch (extension){
            case "docx":
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

        }
        return "";
    }

}

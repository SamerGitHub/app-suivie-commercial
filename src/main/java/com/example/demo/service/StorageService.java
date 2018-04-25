package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class StorageService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocation = Paths.get("upload-dir");
    private final Path clientFileLocation = Paths.get("upload-dir/client");
    private final Path enginFileLocation = Paths.get("upload-dir/engin");
    private final Path otherFileLocation = Paths.get("upload-dir/other");
    public void store(MultipartFile file,String path) {
        try {
            if(path.equals("client"))

            Files.copy(file.getInputStream(), this.clientFileLocation.resolve(file.getOriginalFilename()));

            else if (path.equals("engin"))
                Files.copy(file.getInputStream(), this.enginFileLocation.resolve(file.getOriginalFilename()));
            else
                Files.copy(file.getInputStream(), this.otherFileLocation.resolve(file.getOriginalFilename()));

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename,String path) {
        try {
            Path file ;

           if(path.equals("client"))
             file = clientFileLocation.resolve(filename);
           else
               if(path.equals("engin"))
                    file = enginFileLocation.resolve(filename);
           else
                    file = otherFileLocation.resolve(filename);

            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}

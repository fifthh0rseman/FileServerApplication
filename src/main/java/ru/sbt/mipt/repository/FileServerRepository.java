package ru.sbt.mipt.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.Files.readAllBytes;

@Repository
public class FileServerRepository {
    public void save(String fileName, MultipartFile file){
        try {
            Files.write(Path.of(fileName), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<byte[]> get(String fileName) {
        byte[] file = null;
        try {
            file = readAllBytes(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(file);
    }
}

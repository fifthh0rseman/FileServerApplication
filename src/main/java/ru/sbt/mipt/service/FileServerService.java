package ru.sbt.mipt.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sbt.mipt.repository.FileServerRepository;

import java.util.Optional;

@Service
public class FileServerService {
    private final FileServerRepository repository;

    public FileServerService(FileServerRepository repository) { this.repository = repository; }

    public void saveFile(String fileName, MultipartFile file) { repository.save(fileName, file); }

    public Optional<byte[]> getFile(String fileName) { return repository.get(fileName); }
}

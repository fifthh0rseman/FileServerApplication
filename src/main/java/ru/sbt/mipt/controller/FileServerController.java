package ru.sbt.mipt.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import ru.sbt.mipt.service.FileServerService;

import java.util.Optional;

@RestController
@RequestMapping()
public class FileServerController {
    private final FileServerService service;

    public FileServerController(FileServerService service) { this.service = service; }

    @PostMapping(value = "/file")
    public void saveFile(@RequestParam String filename, @RequestParam MultipartFile file) {
        Logger logger = LoggerFactory.getLogger(FileServerController.class);
        logger.info("Got content:" + file.toString());

        service.saveFile(filename, file);
    }

    @GetMapping("/getFile")
    public ResponseEntity<Optional<byte[]>> getFile(@RequestParam String filename) {
        return ResponseEntity.ok().body(service.getFile(filename));
    }
}

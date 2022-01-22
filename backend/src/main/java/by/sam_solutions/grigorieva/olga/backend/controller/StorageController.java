package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.dto.StorageDto;
import by.sam_solutions.grigorieva.olga.backend.service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;
    private final Logger logger = LoggerFactory.getLogger(StorageController.class);

    @GetMapping("/storages")
    public List<StorageDto> getStorages() {
        logger.info("Getting storages...");
        return storageService.getAll().stream()
                        .map(StorageDto::toDto)
                        .collect(toList()
        );
    }

}

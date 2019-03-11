package com.alandunne.audiofiles.service;

import com.alandunne.audiofiles.repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Slf4j
@Service("databaseStorageService")
public class DatabaseStorageService implements StorageService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void init() {

    }

    @Override
    public void store(final MultipartFile file) {

    }

    //    @SneakyThrows
//    @Override
//    public AudioFile store(MultipartFile file) {
//
//        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        final AudioFile audioFile = new AudioFile(fileName, file.getBytes(), file.getContentType());
//
//        final AudioFile save = fileRepository.save(audioFile);
//
//        log.info("Saved file");
//        log.info(file.getName());
//        log.info(file.getContentType());
//        log.info("Content: " + new String(file.getBytes()));
//
//        return save;
//    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(final String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(final String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

}

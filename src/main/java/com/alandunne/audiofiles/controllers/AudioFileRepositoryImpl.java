package com.alandunne.audiofiles.controllers;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class AudioFileRepositoryImpl implements AudioFileRepository {

    @SneakyThrows
    @Override
    public void store(MultipartFile file) {
        log.info(file.getName());
        log.info(file.getContentType());
        log.info("Content: " + new String(file.getBytes()));
    }

}

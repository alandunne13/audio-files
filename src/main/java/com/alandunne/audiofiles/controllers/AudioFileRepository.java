package com.alandunne.audiofiles.controllers;

import org.springframework.web.multipart.MultipartFile;

public interface AudioFileRepository {

    void store(MultipartFile file);

}

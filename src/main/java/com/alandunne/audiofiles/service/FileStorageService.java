package com.alandunne.audiofiles.service;

import com.alandunne.audiofiles.model.AudioFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;

public interface FileStorageService {

    AudioFile store(MultipartFile file);

    Iterator<AudioFile> getAllFiles();

    AudioFile findById(String id);

}

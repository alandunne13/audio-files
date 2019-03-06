package com.alandunne.audiofiles.service;

import com.alandunne.audiofiles.model.AudioFile;
import com.alandunne.audiofiles.repository.FileRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;

@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileRepository fileRepository;

    @SneakyThrows
    @Override
    public AudioFile store(MultipartFile file) {

        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        final AudioFile audioFile = new AudioFile(fileName, file.getBytes(), file.getContentType());

        final AudioFile save = fileRepository.save(audioFile);

        log.info("Saved file");
        log.info(file.getName());
        log.info(file.getContentType());
        log.info("Content: " + new String(file.getBytes()));

        return save;
    }


    @Override
    public AudioFile findById(final String id) {
        return fileRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("No file found for ID %s", id)));
    }

    @Override
    public Iterator<AudioFile> findAll() {
        final Iterable<AudioFile> all = fileRepository.findAll();
        return all.iterator();
    }

}

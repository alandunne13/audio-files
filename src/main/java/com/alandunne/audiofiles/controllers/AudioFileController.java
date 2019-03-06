package com.alandunne.audiofiles.controllers;

import com.alandunne.audiofiles.model.AudioFile;
import com.alandunne.audiofiles.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(AudioFileController.BASE_PATH)
public class AudioFileController {

    public static final String BASE_PATH = "/audio-files";

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/downloadFile/{id}")
    @ResponseBody
    public ResponseEntity<Resource> getFiles(@PathVariable("id") String id) {

        final AudioFile file = fileStorageService.findById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(new ByteArrayResource(file.getContent()));
    }

    @PostMapping
    @ResponseBody
    public UploadFileResponse addFile(@RequestParam("file") MultipartFile file){

        final AudioFile uploadedFile = fileStorageService.store(file);

        final String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(BASE_PATH + "/downloadFile/")
                .path(uploadedFile.getId())
                .toUriString();

        return new UploadFileResponse(uploadedFile.getFilename(), fileDownloadUri, file.getContentType(), 1);
    }

    @PostMapping("/multiple")
    @ResponseBody
    public List<UploadFileResponse> addMultipleFiles(@RequestParam("files") MultipartFile[] file){
        return Arrays.stream(file)
                .map(this::addFile)
                .collect(Collectors.toList());

    }

}

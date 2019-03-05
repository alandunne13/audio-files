package com.alandunne.audiofiles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("audio-files")
public class AudioFileController {

    @Autowired
    private AudioFileRepository storageService;

    @GetMapping
    @ResponseBody
    public String getFiles(@RequestParam("name") String name) {
        return "get-file:" + name;
    }

    @PostMapping
    @ResponseBody
    public String addFile(@RequestParam("file") MultipartFile file){
        storageService.store(file);
        return "add-file";
    }

}

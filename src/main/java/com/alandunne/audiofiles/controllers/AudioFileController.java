package com.alandunne.audiofiles.controllers;

import com.alandunne.audiofiles.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AudioFileController.BASE_PATH)
public class AudioFileController {

    public static final String BASE_PATH = "/audio-files";

    @Autowired
    private StorageService fileStorageService;

//    @GetMapping("/downloadFile/{id}")
//    @ResponseBody
//    public ResponseEntity<Resource> getFiles(@PathVariable("id") String id) {
//
//        final AudioFile file = fileStorageService.findById(id);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(file.getContentType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//                .body(new ByteArrayResource(file.getContent()));
//    }
//
//    @GetMapping()
//    @ResponseBody
//    public List<UploadFileResponse> getAllFiles() {
//
//        final Iterator<AudioFile> files = fileStorageService.findAll();
//
//        return Streams.stream(files)
//                .map(
//                        f -> {
//                            String s = ServletUriComponentsBuilder.fromCurrentContextPath()
//                                .path(BASE_PATH + "/downloadFile/")
//                                .path(f.getId())
//                                .toUriString();
//
//                            return new UploadFileResponse(f.getFilename(), s, f.getContentType(), 1);}
//                        ).collect(Collectors.toList());
//
//
//    }
//
//    @PostMapping
//    @ResponseBody
//    public UploadFileResponse addFile(@RequestParam("file") MultipartFile file){
//
//        final AudioFile uploadedFile = fileStorageService.store(file);
//
//        final String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path(BASE_PATH + "/downloadFile/")
//                .path(uploadedFile.getId())
//                .toUriString();
//
//        return new UploadFileResponse(uploadedFile.getFilename(), fileDownloadUri, file.getContentType(), 1);
//    }
//
//    @PostMapping("/multiple")
//    @ResponseBody
//    public List<UploadFileResponse> addMultipleFiles(@RequestParam("files") MultipartFile[] file){
//        return Arrays.stream(file)
//                .map(this::addFile)
//                .collect(Collectors.toList());
//
//    }

}

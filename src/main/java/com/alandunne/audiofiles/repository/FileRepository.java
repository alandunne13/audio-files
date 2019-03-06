package com.alandunne.audiofiles.repository;

import com.alandunne.audiofiles.model.AudioFile;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<AudioFile, String> {
}

package com.alandunne.audiofiles.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StorageProperties {

	private String location = "/audio";

}
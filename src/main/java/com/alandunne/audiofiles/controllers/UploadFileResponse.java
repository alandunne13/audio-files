package com.alandunne.audiofiles.controllers;

import lombok.Data;

@Data
public class UploadFileResponse {

	private final String filename;
	private final String fileDownloadUri;
	private final String contentType;
	private final long size;

}

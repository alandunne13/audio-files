package com.alandunne.audiofiles.service;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FileStorageServiceITest {

	private static final String TMP_DIR = "/tmp/audio123";

	private FileStorageService fileStorageService;

	@Before
	public void setUp() throws IOException {
		fileStorageService = new FileStorageService();
		Files.createDirectories(Paths.get(TMP_DIR));
	}

	@Test
	public void testStoreAndRetrieve() {

		MultipartFile file = new MockMultipartFile("myFile.txt", "myFile.txt", "text", "this file".getBytes());

		fileStorageService.store(file);

		final List<Path> resultList = fileStorageService.loadAll().collect(Collectors.toList());
		assertThat(resultList).hasSize(1);

		final Path resultPath = fileStorageService.load("myFile.txt");
		assertThat(resultPath).exists();
		assertThat(resultPath.toFile()).hasContent("this file");

	}

	@After
	public void tearDown() throws IOException {
		FileUtils.deleteDirectory(new File(TMP_DIR));
	}

}

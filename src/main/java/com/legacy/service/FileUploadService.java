package com.legacy.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	private final Path UPLOAD_PATH = Paths.get("C:\\Users\\chaey\\Downloads\\upload");

	public void init() {
		try {
			Files.createDirectory(UPLOAD_PATH);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload");
		}
	}

	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.UPLOAD_PATH.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	public Resource load(String filename) {
		try {
			Path file = UPLOAD_PATH.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file");
			}

		} catch (MalformedURLException e) {
			throw new RuntimeException("Error : " + e.getMessage());
		}
	}

	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.UPLOAD_PATH, 1).filter(path -> !path.equals(this.UPLOAD_PATH)).map(this.UPLOAD_PATH::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files");
		}
	}
}

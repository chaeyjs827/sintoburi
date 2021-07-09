package com.legacy.contoller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.legacy.message.ResponseMessage;
import com.legacy.model.FileInfo;
import com.legacy.service.FileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			fileUploadService.save(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = fileUploadService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build()
					.toString();
			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = fileUploadService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}

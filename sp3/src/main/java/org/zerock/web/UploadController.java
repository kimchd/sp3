package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload1")
	public void upload1() {

	}

	@PostMapping("/upload1")
	public void upload1Post(@RequestParam("file") MultipartFile file) {
		System.out.println("upload post.....");
		System.out.println("getName: " + file.getName());
		System.out.println("getOriginalFileName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
	}
}

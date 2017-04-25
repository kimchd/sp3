package org.zerock.web;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload1")
	public void upload1() {

	}

	@PostMapping(name = "/upload1", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upload1Post(@RequestParam("file") MultipartFile file)throws Exception {
		System.out.println("upload post.....");
		System.out.println("getName: " + file.getName());
		System.out.println("getOriginalFileName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		
		UUID uid = UUID.randomUUID();
		
		String uidStr = uid.toString();
		String saveName = uidStr+"_"+file.getOriginalFilename();
		String thumbName = uidStr+"_s_"+file.getOriginalFilename();
		
		IOUtils.copy(file.getInputStream(), new FileOutputStream("C:\\zzz\\upload\\"+saveName));
		
		BufferedImage src = ImageIO.read(file.getInputStream());
		
		BufferedImage thumb = Scalr.resize(src, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT,100);
		
		ImageIO.write(thumb, "jpg", new FileOutputStream("C:\\zzz\\upload\\"+thumbName));
		
		return thumbName;
	}
}

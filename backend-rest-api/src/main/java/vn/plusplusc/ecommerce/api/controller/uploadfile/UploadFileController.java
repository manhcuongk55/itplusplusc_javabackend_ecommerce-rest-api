/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.api.controller.uploadfile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.controller.AbstractBaseController;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.exception.ApplicationException;
import vn.plusplusc.util.FileUtil;

/**
 *
 * @author manhcuong
 */

@RestController
@RequestMapping(APIName.UPLOAD_API)
public class UploadFileController extends AbstractBaseController {

	@Value("${application.config.upload.basedir}")
	private String uploadPath;

	@RequestMapping(path = APIName.UPLOAD_FILE, method = RequestMethod.POST)
	public ResponseEntity<APIResponse> uploadFile(HttpServletRequest request,
			@RequestParam("file_name") String fileName, @RequestParam("file") MultipartFile file,
			@RequestParam(value = "folder", required = false, defaultValue = "") String newfolder) throws IOException {

		// TODO
		// Get root file Directory Folder
		String filePathDirectory = new File(uploadPath + "/" + newfolder).isAbsolute() ? (uploadPath + "/" + newfolder)
				: request.getServletContext().getRealPath(uploadPath + "/" + newfolder);

		if (!file.isEmpty()) {
			// Create file to storage in server
			// create file name uploaded
			String filePathName = fileName;
			String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
		
			if (filePathName == null || "".equals(filePathName)) {
				filePathName = new Date().getTime() + "." + fileExtension;
			}else{
				filePathName = filePathName + "." + fileExtension;
			}
		
			// Folder to save file
			File folder = new File(filePathDirectory);

			// Write file stream to server storage
			if (!folder.exists()) {
				// create the named directory.
				folder.mkdirs();
			}
			// New filepath
			File destFile = new File(folder, filePathName);
			if (destFile.exists()) {
				destFile.delete();
				destFile = new File(folder, filePathName);
			}
			// Save Multipart buffer into file
			FileUtil.appendFile(file.getInputStream(), destFile);
			return responseUtil.successResponse(filePathName);
		} else {
			throw new ApplicationException(APIStatus.ERR_UPLOAD_FILE);
		}

	}
}

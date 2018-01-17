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
    public ResponseEntity<APIResponse> uploadFile(
            HttpServletRequest request,
            @RequestParam("file_name") String fileName,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "name", required = false, defaultValue = "") String uploadName,
            @RequestParam(value = "chunk", required = false) String chunkRequest,
            @RequestParam(value = "chunks", required = false) String totalChunks
            ) throws IOException {  
        
        // TODO
        // Get root file Directory Folder
        String filePathDirectory = new File(uploadPath).isAbsolute() ? uploadPath : request.getServletContext().getRealPath(uploadPath);
        // Set context path upload
        // Chunk size for Multipart file upload
        Integer chunk = 0, chunks = 0, totalChunkIndex;
        if (null != chunkRequest && !chunkRequest.equals("")) {
            chunk = Integer.valueOf(chunkRequest);
        }
        if (null != totalChunks && !totalChunks.equals("")) {
            chunks = Integer.valueOf(totalChunks);
        }
        //totalChunkIndex
        totalChunkIndex = chunks - 1;

        if (!file.isEmpty()) {
            //Create file to storage in server
            // create file name uploaded
            String filePathName = uploadName;
            String fileExtension = FilenameUtils.getExtension(fileName).toLowerCase();
            if (filePathName == null || "".equals(filePathName)) {
                filePathName = new Date().getTime() + "." + fileExtension;
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
            if (chunk == 0 && destFile.exists()) {
                destFile.delete();
                destFile = new File(folder, filePathName);
            }
            //  Save Multipart buffer into file
            FileUtil.appendFile(file.getInputStream(), destFile);

            // Checking chunk index upload
            // Completed mutipart upload => save file & response sucess
            if (chunk.equals(totalChunkIndex) || totalChunkIndex == -1) {
                // Create database file record
                return responseUtil.successResponse(filePathName);
            }else{
                throw new ApplicationException(APIStatus.ERR_UPLOAD_FILE);
            }
        }else{
            throw new ApplicationException(APIStatus.ERR_UPLOAD_FILE);
        }
        
    }
}

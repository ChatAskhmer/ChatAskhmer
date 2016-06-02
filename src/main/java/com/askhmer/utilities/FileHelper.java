package com.askhmer.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/*
 * @Author Khoem Bunthoeurn
 * 
 */
public class FileHelper {

	/*get extension file
	 * 
	 * @param 	file: file get from request
	 * 
	 * */
	public String getExtension(MultipartFile file){
		return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	}
	
	/*get name date 
	 * 
	 * format(day-month-year-hours-minutes-seconds)
	 * example: 12-02-2016-100523 -> 12 Feb 2016 10:05:23
	 */
	public String getNameDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/*get path server
	 * 
	 * @param src: path to store image 
	 * example: /resources/images/
	 * 
	 * */
	public String getPathServer(HttpServletRequest request, String src){
		return request.getSession().getServletContext().getRealPath(src);
	}
	
	/*create path local file
	 * 
	 * @param pathServer: get from method getPathServer Above. 
	 * example: 
	 * D:\ProjectJava\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\SpringCRUDRestfulApi\resources\images
	 * 
	 * */
	public void createPathLocal(String pathServer){
		File path = new File(pathServer);
		if(!path.exists()){
			path.mkdir();
		}
	}	

	/*upload file to server
	 * 
	 * @params 	pathServer: get from method getPathServer
	 * 			filename: get from file name 
	 * 			file: to get size of file
	 * */
	public boolean uploadSingleFile(String pathServer,
									String filename,
									MultipartFile file){
		try {
			byte[] bytes = file.getBytes();
			
			File server_file = new File(pathServer + File.separator + filename);				
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(server_file));
		
			stream.write(bytes);
			stream.close();
			
			return true;
			
		} catch (IOException e) {
			return false;
		}		
	}
	
	/*delete file
	 * 
	 * @param	pathServer: get from method getPathServer
	 * 			filename: get from file name
	 * 
	 * */
	public boolean deleteSingleFile(String pathServer, String filename){
		File file = new File(pathServer + File.separator + filename);
		if(file.delete())
		{	return true; 	} 
		else 
		{	return false;	}
	}
		
}


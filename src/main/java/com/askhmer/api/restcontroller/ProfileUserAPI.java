package com.askhmer.api.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.askhmer.model.dto.ProfileUserDTO;
import com.askhmer.services.ProfileUserService;
import com.askhmer.utilities.FileHelper;

@RestController
@RequestMapping(value="/api/profile")
public class ProfileUserAPI extends FileHelper{
	
	@Autowired
	ProfileUserService profileUserService;

	/*	To get brief user information in fragment
	 * 	URL Sample => /briefUserInfo?fid=null&phnum=null&em=th_kbt@yahoo.com
	 *  Need at least one params value
	 *  @param fid -> facebook id
	 *  @param phnum  -> phone number
	 *  @param em 	-> email
	 */
	@RequestMapping(value = "/briefuserinfo", method= RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getBriefUserInfo(@RequestParam("fid") String facebook_id,
																@RequestParam("phnum") String phone_number, 
																@RequestParam("em") String email){
		ProfileUserDTO profileUser = new ProfileUserDTO();
		profileUser.setFacebook_id(facebook_id);
		profileUser.setUser_phone_num(phone_number);
		profileUser.setUser_email(email);
		
		Map<String , Object> map = new HashMap<String, Object>();
		List<ProfileUserDTO> lstProfileUser = profileUserService.getBriefUserInfoService(profileUser);
		map.put("data", lstProfileUser);
		if(lstProfileUser.isEmpty()){
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/* To get the detail user information in view profile
	 * @param user_id 
	 * 
	 * */
	@RequestMapping(value="/detailuserinfo/{user_id}", method= RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getDetailUserInfo(@PathVariable("user_id") int user_id){
		Map<String , Object> map = new HashMap<String, Object>();
		List<ProfileUserDTO> lstProfileUser = profileUserService.getDetailUserInfoService(user_id);
		map.put("data", lstProfileUser);
		if(lstProfileUser.isEmpty()){
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/* to update user information in view profile
	 * @param user_id
	 * @param user_name
	 * @param user_no
	 * @param user_phone_num
	 * @param user_current_city
	 * @param user_hometown
	 * 
	 * */
	@RequestMapping(value="/modifyuserinto/{user_id}", method=RequestMethod.POST, headers={"content-type=application/x-www-form-urlencoded","Accept=application/json"})
	@ResponseBody
	public ResponseEntity<Map<String, Object>> doModifyUserInfo(@PathVariable("user_id") int user_id,
																@ModelAttribute("profileUser") ProfileUserDTO profileUser){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProfileUserDTO> lstProfileUser = profileUserService.modifiedUserInfoService(user_id, profileUser);
		map.put("data", lstProfileUser);
		
		if(lstProfileUser.isEmpty())
		{ return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NO_CONTENT); }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/* To get user_id and email in view change password
	 * @param user_id
	 * 
	 * */
	@RequestMapping(value="/getcurrentemailpassword/{user_id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getCurrentEmailPassword(@PathVariable("user_id") int user_id){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProfileUserDTO> lstProfileUser = profileUserService.getCurrentPasswordService(user_id);
		map.put("data", lstProfileUser);
		
		if(lstProfileUser.isEmpty())
		{ return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NO_CONTENT); }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/* To check correct password and email and userid when want to change new password
	 * @param user_id
	 * @param user_email
	 * @param user_password
	 * 
	 * */
	@RequestMapping(value="/isvalidauth/{user_id}", method=RequestMethod.POST, headers={"content-type=application/x-www-form-urlencoded","Accept=application/json"})
	@ResponseBody
	public ResponseEntity<Map<String, Object>> isValidAuthToChange(@PathVariable("user_id") int user_id,
																   @ModelAttribute("profileUser") ProfileUserDTO profileUser){
		boolean isUpdated = profileUserService.isValidAuthService(user_id, profileUser);
		Map<String, Object> map = new HashMap<String, Object>();
		if(isUpdated == false){
			map.put("status", "fail");
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_FOUND);
		} else {
			map.put("status", "success");
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
	}
	
	/* To change new password or to set up email and password 
	 * @param user_id
	 * @param user_email
	 * @param user_password
	 * 
	 * */
	@RequestMapping(value="/modifyauthinfo/{user_id}", method=RequestMethod.POST, headers={"content-type=application/x-www-form-urlencoded","Accept=application/json"})
	@ResponseBody
	public ResponseEntity<Map<String, Object>> modifyAuthInfo(@PathVariable("user_id") int user_id,
															  @ModelAttribute("profileUser") ProfileUserDTO profileUser){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProfileUserDTO> lstProfileUser = profileUserService.modifiedCurrentPasswordService(user_id, profileUser);
		map.put("data", lstProfileUser);
		
		if(lstProfileUser.isEmpty())
		{ return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NO_CONTENT); }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/*To update image photo profile
	 * @param user_id
	 * @param user_photo
	 * 
	 * */
	@RequestMapping(value="/modifyphoto/{user_id}", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> modifyPhoto(
															@PathVariable("user_id") int user_id,
															@RequestParam("user_photo") MultipartFile file,
															HttpServletRequest request){
		String filename = "";
		String src_img = "";
		Map<String, Object> map = new HashMap<String, Object>();		
		
		if(!file.isEmpty()){		
				String current = getNameDate();
				String extension = getExtension(file);
				if(!extension.equals(".jpg") && !extension.equals(".png") && !extension.equals(".gif")){
					map.put("status", "not correct extension");
					return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_FOUND);
				}
				
				/* replace file name */
				filename = current + extension;
				src_img = "/resources/images/";
				
				String path_server = getPathServer(request, src_img);
				createPathLocal(path_server);
				
				boolean msgHandle = uploadSingleFile(path_server, filename, file);
				if(msgHandle == true)
				{ 
					String filenamefull = src_img+filename;					
//					System.out.println("Upload Success: " + path_server + filenamefull);
					List<ProfileUserDTO> lstProfileUser = profileUserService.modifiedPhotoService(user_id, filenamefull);
					if(lstProfileUser.isEmpty())
					{	
						map.put("status", "no data");
						return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_FOUND);
					}
					map.put("data", lstProfileUser);
					return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
				} else {
					map.put("status", "failed update");
					return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_FOUND);
				}
		} else {
			map.put("status", "no photo file");
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_FOUND);
		}
	
	}
}

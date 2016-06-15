package com.askhmer.servicesImpl;

import java.util.List;

import com.askhmer.model.dto.ProfileUserDTO;

public interface ProfileUserService {
	
	public List<ProfileUserDTO> getBriefUserInfoService(ProfileUserDTO profileUser);
	public List<ProfileUserDTO> getDetailUserInfoService(int user_id);
	public List<ProfileUserDTO> modifiedUserInfoService(int user_id, ProfileUserDTO profileUser);
	
	public List<ProfileUserDTO> getCurrentPasswordService(int user_id);
	public boolean isValidAuthService(int user_id, ProfileUserDTO profileUser);
	public List<ProfileUserDTO> modifiedCurrentPasswordService(int user_id, ProfileUserDTO profileUser);
	public List<ProfileUserDTO> modifiedPhotoService(int user_id, String photo);
}

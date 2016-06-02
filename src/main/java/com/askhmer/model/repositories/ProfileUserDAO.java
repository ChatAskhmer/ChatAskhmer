package com.askhmer.model.repositories;

import java.util.List;
import com.askhmer.model.dto.ProfileUserDTO;

public interface ProfileUserDAO {
	
	public List<ProfileUserDTO> getBriefUserInfoRepository(ProfileUserDTO profileUser);
	public List<ProfileUserDTO> getDetailUserInfoRepository(int user_id);
	public List<ProfileUserDTO> modifiedUserInfoRepository(int user_id, ProfileUserDTO profileUser);
	
	public List<ProfileUserDTO> getCurrentPasswordRepository(int user_id);
	public boolean isValidAuth(int user_id, ProfileUserDTO profileUser);
	public List<ProfileUserDTO> modifiedCurrentPasswordRepository(int user_id, ProfileUserDTO profileUser);
	public List<ProfileUserDTO> modifiedPhotoRepository(int user_id, String photo);
	
}

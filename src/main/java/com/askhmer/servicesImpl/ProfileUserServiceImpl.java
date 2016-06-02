package com.askhmer.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askhmer.model.dto.ProfileUserDTO;
import com.askhmer.model.repositories.ProfileUserDAO;
import com.askhmer.services.ProfileUserService;

@Service
public class ProfileUserServiceImpl implements ProfileUserService{
	
	@Autowired
	ProfileUserDAO profileUserDAO;
	
	@Override
	public List<ProfileUserDTO> getBriefUserInfoService(ProfileUserDTO profileUser) {
		return profileUserDAO.getBriefUserInfoRepository(profileUser);
	}

	@Override
	public List<ProfileUserDTO> getDetailUserInfoService(int user_id) {
		return profileUserDAO.getDetailUserInfoRepository(user_id);
	}

	@Override
	public List<ProfileUserDTO> modifiedUserInfoService(int user_id, ProfileUserDTO profileUser) {
		return profileUserDAO.modifiedUserInfoRepository(user_id, profileUser);
	}

	@Override
	public List<ProfileUserDTO> getCurrentPasswordService(int user_id) {
		return profileUserDAO.getCurrentPasswordRepository(user_id);
	}

	@Override
	public boolean isValidAuthService(int user_id, ProfileUserDTO profileUser) {
		return profileUserDAO.isValidAuth(user_id, profileUser);
	}

	@Override
	public List<ProfileUserDTO> modifiedCurrentPasswordService(int user_id, ProfileUserDTO profileUser) {
		return profileUserDAO.modifiedCurrentPasswordRepository(user_id, profileUser);
	}

	@Override
	public List<ProfileUserDTO> modifiedPhotoService(int user_id, String photo) {
		return profileUserDAO.modifiedPhotoRepository(user_id, photo);
	}

	

}

package com.askhmer.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askhmer.model.dto.UserDto;
import com.askhmer.model.repositories.UserDao;
import com.askhmer.services.UserServices;

/**
 * 
 * @author soklundy
 *
 */
@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDao userDao;
	
	@Override
	public int register(UserDto userDto) {
		return userDao.register(userDto);
	}

	@Override
	public int checkHasUser(String facebookIdOrPhone) {
		return userDao.checkHasUser(facebookIdOrPhone);
	}

	@Override
	public int registerWithFb(UserDto userDto) {
		int userId = userDao.checkHasUser(userDto.getFacebookId());
		if (userId == 0) {
			return userDao.register(userDto);
		}
		return userId;
	}

	@Override
	public List<UserDto> searchUserByUserNoOrName(String searchUserNoOrName, String IdUserUseApp) {
		List<UserDto> users = userDao.searchUserByUserNoOrName(searchUserNoOrName, IdUserUseApp);
		return users;
	}

}

package com.askhmer.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;
import com.askhmer.model.repositories.FriendDao;
import com.askhmer.services.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDao friendDao;

	@Override
	public boolean addFriend(FriendDto friendDto) {
		return friendDao.addFriend(friendDto);
	}

	@Override
	public UserDto viewfriendById(int user_id) {
		return friendDao.viewfriendById(user_id);
	}

	@Override
	public List<Integer> listFriendIdById(int user_id) {
		// TODO Auto-generated method stub
		return friendDao.listFriendIdById(user_id);
	}

	@Override
	public List<UserDto> listFriendById(int user_id) {
		// TODO Auto-generated method stub
		return friendDao.listFriendById(user_id);
	}

	@Override
	public boolean unFriend(FriendDto friendDto) {
		return friendDao.unFriend(friendDto);
	}

	@Override
	public ArrayList<UserDto> searchFriend(String kesearch,int user_id) {
		// TODO Auto-generated method stub
		return friendDao.searchFriend(kesearch,user_id);
	}

	

}

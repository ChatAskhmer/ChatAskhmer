package com.askhmer.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.repositories.FriendDao;
import com.askhmer.services.FriendService;

@Service
public class FriendServiceImpl implements FriendService{
	
	@Autowired
	private FriendDao friendDao;

	@Override
	public boolean addFriend(FriendDto friendDto) {
		return friendDao.addFriend(friendDto);
	}

}

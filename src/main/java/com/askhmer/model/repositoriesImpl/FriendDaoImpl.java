package com.askhmer.model.repositoriesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askhmer.model.dto.FriendDto;
import com.askhmer.model.dto.UserDto;
import com.askhmer.model.repositories.FriendDao;

@Repository
public class FriendDaoImpl implements FriendDao {

	@Autowired
	private DataSource dataSource;
	Connection cnn;
	
	public List<Integer> listFriendIdById(int user_id) {

		List<Integer> friendId = new ArrayList<Integer>();
		ResultSet rs = null;
		System.err.println("error");
		try {
			String sql = "SELECT user_id FROM tbl_friend WHERE friend_id = ? AND is_friend = 1 UNION (SELECT friend_id FROM tbl_friend WHERE user_id = ? AND is_friend = 1)";
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, user_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				friendId.add(rs.getInt("user_id"));
			}
			return friendId;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public UserDto viewfriendById(int user_id) {

		try {

			cnn = dataSource.getConnection();
			String sql = "SELECT user_id, user_name, gender, user_no, user_photo,user_email,user_hometown,user_phone_num FROM tbl_user WHERE user_id=?";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			UserDto dto = null;
			if (rs.next()) {
				dto = new UserDto();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setGender(rs.getString("gender"));
				dto.setUserNo(rs.getString("user_no"));
				dto.setUserPhoto(rs.getString("user_photo"));
				dto.setUserEmail(rs.getString("user_email"));
				dto.setUserHometown(rs.getString("user_hometown"));
				dto.setUserPhoneNum(rs.getString("user_phone_num"));
				return dto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean addFriend(FriendDto friendDto) {
		final String SQLADDFRIEND = "INSERT INTO tbl_friend(friend_id,user_id) values(?,?)";
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLADDFRIEND);) {
			ps.setInt(1, friendDto.getFriendId());
			ps.setInt(2, friendDto.getUserId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<UserDto> listFriendById(int user_id) {
		List<UserDto> friend = new ArrayList<UserDto>();
		UserDto dto = null;
		ResultSet rs = null;
		System.err.println("error");
		try {
			String sql = "SELECT user_id, user_name, gender, user_no,user_photo FROM tbl_user WHERE user_id IN(SELECT user_id FROM tbl_friend WHERE friend_id = ? AND is_friend = 1 UNION (SELECT friend_id FROM tbl_friend WHERE user_id = ? AND is_friend = 1))";
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, user_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new UserDto();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setGender(rs.getString("gender"));
				dto.setUserNo(rs.getString("user_no"));
				dto.setUserPhoto(rs.getString("user_photo"));
				friend.add(dto);
			}
			return friend;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean unFriend(FriendDto friendDto) {
		final String SQLUNFRIEND = "UPDATE tbl_friend SET un_friend = true WHERE "
				+ "((user_id = ? and friend_id = ?) or (user_id= ? and friend_id = ?))"
				+ " and "
				+ "un_friend = false";
		
		try (Connection cnn = dataSource.getConnection(); PreparedStatement ps = cnn.prepareStatement(SQLUNFRIEND);) {
			ps.setInt(1, friendDto.getUserId());
			ps.setInt(2, friendDto.getFriendId());
			ps.setInt(3, friendDto.getFriendId());
			ps.setInt(4, friendDto.getUserId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	
	
	
//	@Override
//	public ArrayList<Playlist> searchPlayList(String kesearch, Pagination pagin) {
//		try {
//			con = dataSource.getConnection();
//			ArrayList<Playlist> playlists =new ArrayList<Playlist>();
//			int begin =(pagin.getItem()*pagin.getPage())-pagin.getItem();
//			
//			ResultSet rs = null;
//			String sql = "SELECT * FROM tblplaylist P "
//							+"WHERE LOWER(P.playlistname) LIKE LOWER(?) "
//							+"order by playlistid desc offset ? limit ?"; 
//								
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, "%"+kesearch+"%");
//			ps.setInt(2, begin);
//			ps.setInt(3, pagin.getItem());
//			rs = ps.executeQuery();
//			while(rs.next()){
//				
//				Playlist playlist = new Playlist();
//				playlist.setPlaylistId(Encryption.encode(rs.getString("playlistid")));
//				playlist.setPlaylistName(rs.getString("playlistname"));
//				playlist.setDescription(rs.getString("description"));
//				playlist.setUserId(Encryption.encode(rs.getString("userid")));
//				playlist.setThumbnailUrl(rs.getString("thumbnailurl"));
//				playlist.setPublicView(rs.getBoolean("publicview"));
//				playlist.setMaincategory(Encryption.encode(rs.getString("maincategory")));
//				playlist.setBgImage(rs.getString("bgimage"));
//				playlist.setColor(rs.getString("color"));
//				playlist.setStatus(rs.getBoolean("status"));
//				playlist.setCountVideos(this.countVideoInPlayList(rs.getInt("playlistid")));
//				playlists.add(playlist);
//			}
//			return playlists;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//	
	

@Override
public ArrayList<UserDto> searchFriend(String kesearch, int user_id) {
	try {
		cnn = dataSource.getConnection();
		ArrayList<UserDto> friendlists =new ArrayList<UserDto>();
	//	int begin =(pagin.getItem()*pagin.getPage())-pagin.getItem();
		
		ResultSet rs = null;
//		String sql = "SELECT * FROM tblplaylist P "
//						+"WHERE LOWER(P.playlistname) LIKE LOWER(?) "
//						+"order by playlistid desc offset ? limit ?"; 
		
		
		String sql = "SELECT user_id, user_name, gender, user_no,user_photo FROM "
				    +"tbl_user WHERE LOWER(user_name) LIKE LOWER(?) AND user_id "
				    +"IN(SELECT user_id FROM tbl_friend WHERE friend_id = ? AND is_friend = 1 "
				    +"UNION (SELECT friend_id FROM tbl_friend WHERE user_id = ? AND is_friend = 1))";
		
							
		PreparedStatement ps = cnn.prepareStatement(sql);
		ps.setString(1, "%"+kesearch+"%");
		ps.setInt(2, user_id);
		ps.setInt(3, user_id);
//		ps.setInt(2, begin);
//		ps.setInt(3, pagin.getItem());
		rs = ps.executeQuery();
		while(rs.next()){
			
			UserDto dto = new UserDto();
			dto.setUserId(rs.getInt("user_id"));
			dto.setUserName(rs.getString("user_name"));
			dto.setGender(rs.getString("gender"));
			dto.setUserNo(rs.getString("user_no"));
			dto.setUserPhoto(rs.getString("user_photo"));
			friendlists.add(dto);
			
		}
		return friendlists;
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}
}

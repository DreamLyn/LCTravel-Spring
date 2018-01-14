package com.lc.travel.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.travel.dao.PeerMapper;
import com.lc.travel.dao.TouristMapper;
import com.lc.travel.dao.TravelMapperbak;
import com.lc.travel.dao.UserMapper;
import com.lc.travel.entity.Peer;
import com.lc.travel.entity.Tourist;
import com.lc.travel.entity.Travel;
import com.lc.travel.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public ArrayList<User> getUsers(){
		return userMapper.getUsers();
	}
	
	/**
	 * 获取用户
	 * @param name
	 * @return
	 */
	public User getUserByName(String name) {
		return userMapper.selectByPrimaryKey(name);
	}
	
	/**
	 * 更新
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteUser(String name) {
		return userMapper.deleteByPrimaryKey(name);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteUsers(ArrayList<String> names) {
		for(String name:names) {
			deleteUser(name);
		}
	}
	/**
	 * 插入用户
	 * @param record
	 * @return
	 */
	public int insertUser(User record) {
		return userMapper.insertSelective(record);
	}
}

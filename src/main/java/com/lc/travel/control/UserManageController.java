package com.lc.travel.control;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.travel.beans.PeerInfoWithCount;
import com.lc.travel.entity.Peer;
import com.lc.travel.entity.User;
import com.lc.travel.service.PeerService;
import com.lc.travel.service.UserService;

/**
 * 旅行社信息控制器
 */
@Controller
@RequestMapping("/usermanage")
public class UserManageController {
	
	@Autowired
	private UserService userService;
	/**
	 * 获取所有用户信息
	 * @return
	 */
	@RequestMapping(value = "/getusers")
	@ResponseBody
	public HashMap<String, Object> getUsers() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<User> arrayList = userService.getUsers();
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}
	/**
	 * 更新用户信息
	 * @param peer
	 * @return
	 */
	@RequestMapping(value = "/updateuser")
	@ResponseBody
	public HashMap<String, Object> updateUser(User user) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		SimpleHash sh=new SimpleHash("MD5", user.getPassword(), user.getName(),16);
		user.setPassword(sh.toString());
		if(userService.updateByPrimaryKeySelective(user)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/deleteuser")
	@ResponseBody
	public HashMap<String, Object> deleteUser(String name) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(userService.deleteUser(name)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/deleteusers")
	@ResponseBody
	public HashMap<String, Object> deletePeers(String idString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<String> nameList = mapper.readValue(idString, new TypeReference<List<String>>() {
		});
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		userService.deleteUsers(nameList);
		hashMap.put("status", "success");
		hashMap.put("content", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/insertuser")
	@ResponseBody
	public HashMap<String, Object> insertPeer(User user) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		SimpleHash sh=new SimpleHash("MD5", user.getPassword(), user.getName(),16);
		user.setPassword(sh.toString());
		if(userService.insertUser(user)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
}

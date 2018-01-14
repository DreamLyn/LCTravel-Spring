package com.lc.travel.control;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 旅行社信息控制器
 */
@Controller
@RequestMapping("/login")
public class ShiroController {

	@Autowired
	private UserService userService;

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/")
	@ResponseBody
	public HashMap<String, Object> login(String username, String password) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		HashMap<String, Object> content = new HashMap<String, Object>();
		// 1、创建Subject实例
		Subject currentUser = SecurityUtils.getSubject();
		// 2、判断当前用户是否登陆
		if (currentUser.isAuthenticated() == false) {
			// 3、将用户名和密码封装成UsernamePasswordToken
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			// 4、登陆
			try {
				currentUser.login(token);
				content.put("content", "success");
				content.put("token", currentUser.getSession().getId());
				hashMap.put("content", content);
			} catch (AuthenticationException e) {
				content.put("content", "error");
				hashMap.put("content", content);
			}
		} else {
			content.put("content", "success");
			content.put("token", currentUser.getSession().getId());
			hashMap.put("content", content);
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 是否登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/islogin")
	@ResponseBody
	public HashMap<String, Object> isLogin() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		// 1、创建Subject实例
		Subject currentUser = SecurityUtils.getSubject();
		// 2、判断当前用户是否登陆
		if (currentUser.isAuthenticated() == false) {
			hashMap.put("content", false);
		} else {
			hashMap.put("content", true);
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 是否登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getcurrentuser")
	@ResponseBody
	public HashMap<String, Object> getCurrentUser() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		// 1、创建Subject实例
		Subject currentUser = SecurityUtils.getSubject();
		// 2、判断当前用户是否登陆
		if (currentUser.isAuthenticated() == false) {
			hashMap.put("content", null);
		} else {
			hashMap.put("content", currentUser.getPrincipal());
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 是否登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getrole")
	@ResponseBody
	public HashMap<String, Object> getRole() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		// 1、创建Subject实例
		Subject currentUser = SecurityUtils.getSubject();
		// 2、判断当前用户是否登陆
		if (currentUser.isAuthenticated() == false) {
			hashMap.put("content", null);
		} else {
			String username = (String) currentUser.getPrincipal();
			User user = userService.getUserByName(username);
			if (user != null) {
				hashMap.put("content", user.getRole());
			} else {
				hashMap.put("content", null);
			}

		}
		hashMap.put("status", "success");
		return hashMap;
	}
}

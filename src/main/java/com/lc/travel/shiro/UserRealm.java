package com.lc.travel.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.lc.travel.entity.User;
import com.lc.travel.service.UserService;

public class UserRealm extends AuthorizingRealm{
	@Autowired 
	private UserService userService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info=null;
		
		String username=principals.toString();
		User user=userService.getUserByName(username);
		if(user!=null) {
			Object principal=username;
			ByteSource salt=new ByteSource.Util().bytes(username);
			Set<String>roles=new HashSet<String>();
			roles.add(user.getRole());
			info=new SimpleAuthorizationInfo(roles);
		}else {
			throw new AuthenticationException();
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		SimpleAuthenticationInfo info=null;
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		User user=userService.getUserByName(username);
		if(user!=null) {
			Object principal=username;
			ByteSource salt=new ByteSource.Util().bytes(username);
			info=new SimpleAuthenticationInfo(principal,user.getPassword(),salt,user.getName());
		}else {
			throw new AuthenticationException();
		}
		return info;
	}

}

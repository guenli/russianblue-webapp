package com.jwj.russianblue.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwj.russianblue.dao.RbUserDao;
import com.jwj.russianblue.entity.RbUser;

@Getter
@Component("rbAuthenticationService")
public class RbAuthenticationServiceImpl implements UserDetailsService {
	
	@Resource(name="rbUserDao")
    private RbUserDao userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		final RbUser domainUser = userDAO.findByCode(login);
		boolean credentialsExpired = false;

		return new User(
			domainUser.getCode(),
			domainUser.getPassword(),
			domainUser.isEnable(),
			!domainUser.getIsExpire(),
			!credentialsExpired,
			!domainUser.getIsLock(),
			getAuthorities(2)
		);
	}
	
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");
		}
		
		return roles;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		return authorities;
	}

}

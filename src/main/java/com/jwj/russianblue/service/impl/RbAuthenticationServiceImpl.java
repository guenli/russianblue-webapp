package com.jwj.russianblue.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import lombok.Getter;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.enums.YesNo;
import com.jwj.russianblue.dao.RbRoleDao;
import com.jwj.russianblue.dao.RbUserDao;
import com.jwj.russianblue.entity.RbRole;
import com.jwj.russianblue.entity.RbUser;

@Getter
@Component("rbAuthenticationService")
public class RbAuthenticationServiceImpl implements UserDetailsService {
	
	protected final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	
	@Resource(name="rbUserDao")
    private RbUserDao userDao;
	
	@Resource(name="rbRoleDao")
	private RbRoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final RbUser user = userDao.findByCode(username);
		
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.notFound", new Object[] { username },
					"Username {0} not found"));
		}
		
		final boolean credentialsExpired = false;
		UserDetails userDetails = new User(
			user.getCode(),
			user.getPassword(),
			YesNo.Y.equals(user.getSysStatus()),
			!user.getIsExpire(),
			!credentialsExpired,
			!YesNo.Y.equals(user.getLockStatus()),
			getAuthorities(user.getId())
		);
		
		return userDetails;
	}
	
	public List<RbRole> getRoles(Long userId) {
		List<RbRole> roles = roleDao.findByUserId(userId);
		
		return roles;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Long userId) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(userId));
        return authList;
    }
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<RbRole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (RbRole role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		return authorities;
	}

}

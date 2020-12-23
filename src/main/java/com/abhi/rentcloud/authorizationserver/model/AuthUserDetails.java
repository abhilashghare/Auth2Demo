package com.abhi.rentcloud.authorizationserver.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthUserDetails extends User implements UserDetails{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthUserDetails(User user) {
		super(user);
	}

	public  AuthUserDetails() {

	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> grantedAuthority=new ArrayList<>();
		getRoles().forEach(role ->{
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission-> {
				grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));
			});
		});
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.isAccountnonexpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isAccountnonexpired();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.isCredentialsnonexpired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

}

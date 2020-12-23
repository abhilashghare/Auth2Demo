package com.abhi.rentcloud.authorizationserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhi.rentcloud.authorizationserver.model.AuthUserDetails;
import com.abhi.rentcloud.authorizationserver.model.User;
import com.abhi.rentcloud.authorizationserver.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Optional<User> optionalUser=userDetailsRepository.findByUsername(name);
		optionalUser.orElseThrow(()-> new UsernameNotFoundException("Username or Password is Wrong"));
		UserDetails userDetails=new AuthUserDetails(optionalUser.get());
		
		new AccountStatusUserDetailsChecker().check(userDetails);
		
		return userDetails;
	
	}

}

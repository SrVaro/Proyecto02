package com.grupo01.lucatinder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;

@Service
public class SecurityServiceImpl implements  UserDetailsService {
	
	
	@Autowired
	private ProfileRepository profileR;
	
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername (String name)throws UsernameNotFoundException {
		
		Optional <Profile> us = profileR.getProfile(name);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority("USER"));
		UserDetails userDet = new User(us.get().getName(),us.get().getPassword(),roles);
		return userDet;
	}
}

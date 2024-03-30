package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import entity.User;
import repository.UserRepository;

public class GroupUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository UserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = UserRepo.findByUsrname(username);
		return null;
	}

}

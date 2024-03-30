package Durgesh.StreamApi.spring.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//	List<Users> list = new ArrayList<>();
//
//	public UserService() {
//		list.add(new Users("archana", "admin", "abc@gmail.com"));
//		list.add(new Users("arpita", "admin", "pqr@gmail.com"));
//		list.add(new Users("aditya", "admin", "xyz@gmail.com"));
//		list.add(new Users("rohan", "admin", "mno@gmail.com"));
//		list.add(new Users("Sujata", "admin", "efg@gmail.com"));
//		list.add(new Users("santosh", "admin", "hij@gmail.com"));
//	}
	@Autowired
	UserRepository userRepo;

	// get all users
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

	// get specific user
	public Users getUser(String username) {
		return userRepo.findByUsername(username);
	}

	// add user
	public Users addUser(Users user) {
		userRepo.save(user);
		return user;
	}

	// delete user
	public void deleteUser(String username) {
		Users user = userRepo.findByUsername(username);
		if (user != null) {
			userRepo.delete(user);
		}
	}

}

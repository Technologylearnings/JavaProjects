package Durgesh.StreamApi.spring.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	// get all users
	@GetMapping("/")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	// get specific user
	@GetMapping("/{username}")
	public Users getUser(@PathVariable("username") String username) {
		return userService.getUser(username);
	}

	// Add user
	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}

	// delete user
	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(username);
	}

}

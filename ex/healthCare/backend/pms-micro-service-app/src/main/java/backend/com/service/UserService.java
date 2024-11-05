package backend.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.User;
import backend.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findUser(String email) {
		Optional<User> res=userRepository.findById(email);
		if(res.isPresent()) {
			return res.get();
		}else {
			return null;
		}
	}
	
	public String editUser(User user) {
		if(userRepository.editUser(user.getPassword(), user.getPhonenumber(), user.getAddress(), user.getEmail())>0) {
			return "Profile updated succesfully";
		}else {
			return "Profile didn't update";
		}
	}
}

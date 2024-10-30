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
	
	public User findUser(String emailid) {
		Optional<User> result=userRepository.findById(emailid);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
	
	public String editUser(User user) {
		int rowsUpdated=userRepository.editUser(user.getPassword(), user.getPhonenumber(), user.getAddress(), user.getEmailid());
		if(rowsUpdated>0) {
			return "Profile Updated ";
		}else {
			return "profile not updated";
		}
	}
}

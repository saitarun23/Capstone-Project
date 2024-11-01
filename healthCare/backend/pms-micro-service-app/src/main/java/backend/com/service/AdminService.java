package backend.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Login;
import backend.com.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public String checkAdmin(Login login) {
		Login ll = adminRepository.checkAdminLogin(login.getEmail(), login.getPassword());
		if (ll == null) {
			return "Invalid Admin credential";
		} else {
			return "success";
		}
	}
}

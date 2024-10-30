package backend.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.com.entity.Account;
import backend.com.entity.Login;
import backend.com.entity.User;
import backend.com.repository.AccountRepository;
import backend.com.repository.LoginRepository;
import backend.com.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	public String signIn(Login login) {
        Optional<Login> result = loginRepository.findById(login.getEmailid());
        if (result.isPresent()) {
            Login ll = result.get();
            if (ll.getPassword().equals(login.getPassword())) {
                if (ll.getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")) {
                    return "Admin login successfully";
                } else if (ll.getTypeofuser().equals("customer") && login.getTypeofuser().equals("customer")) {
                    return "Customer login successfully";
                } else {
                    return "Type of user is incorrect";
                }
            } else {
                return "Password is incorrect";
            }
        } else {
            return "Email ID is incorrect";
        }
    }

    // Method for signing up a new user
    public String signUp(Login login) {
        if (login.getTypeofuser().equals("admin")) {
            return "You can't create admin login";
        } else {
            Optional<Login> result = loginRepository.findById(login.getEmailid());
            if (result.isPresent()) {
                return "Account already exists";
            } else {
                loginRepository.save(login);
                return "Account created successfully";
            }
        }
    }

    // New method for creating Login, User, and Account entities
    @Transactional
    public String createAccount(User user) {
        Optional<Login> existingLogin = loginRepository.findById(user.getEmailid());
        if (existingLogin.isPresent()) {
            return "User or account with this email already exists";
        } else {
            // Create Login
            Login login = new Login();
            login.setEmailid(user.getEmailid());
            login.setPassword(user.getPassword());
            login.setTypeofuser("customer"); // Assuming all new users are customers
            
            // Save Login and User
            loginRepository.save(login);
            userRepository.save(user);

            // Initialize Account with a starting balance
            Account account = new Account();
            account.setEmailid(user.getEmailid());
            account.setAmount(1000);  // Starting balance
            accountRepository.save(account);
            
            return "User, login, and account created successfully";
        }
    }
}

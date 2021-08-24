package com.owasp.services;

import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.owasp.exception.AuthException;
import com.owasp.model.User;
import com.owasp.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) {
        if (email != null) {
            email = email.toLowerCase();
        }

        User user = userRepository.findByEmail(email);
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new AuthException("Invalid email/password");
        }

        return user;
    }

    @Override
    public User registerUser(User user) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        String email = user.getEmail();
        if (email != null) {
            email = email.toLowerCase();
        }

        if (!pattern.matcher(email).matches()) {
            throw new AuthException("Invalid email format");
        }

        Integer count = userRepository.countByEmail(user.getEmail());
        if (count > 0) {
            throw new AuthException("Email already in use");
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

}

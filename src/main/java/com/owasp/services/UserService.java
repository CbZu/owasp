package com.owasp.services;

import com.owasp.model.User;

public interface UserService {
    User validateUser(String email, String password);
    User registerUser(User user);
}

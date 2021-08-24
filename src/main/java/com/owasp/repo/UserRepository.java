package com.owasp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.owasp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    int countByEmail(String email);
    User findByEmail(String email);
}

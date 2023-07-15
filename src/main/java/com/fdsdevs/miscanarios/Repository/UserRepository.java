package com.fdsdevs.miscanarios.Repository;

import com.fdsdevs.miscanarios.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByEmail(String email);
}

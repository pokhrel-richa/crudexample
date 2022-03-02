package com.crudexample.crudexample.repository;

import com.crudexample.crudexample.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTokenRepository extends JpaRepository<UserToken, Long> {
    public UserToken findByToken(String token);
}

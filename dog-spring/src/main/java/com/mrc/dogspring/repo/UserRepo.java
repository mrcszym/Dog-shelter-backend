package com.mrc.dogspring.repo;

import com.mrc.dogspring.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}

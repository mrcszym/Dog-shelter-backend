package com.mrc.dogspring.service;

import com.mrc.dogspring.domain.AppUser;
import com.mrc.dogspring.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
    AppUser getUser(String email);
    List<AppUser> getUsers();
}

package com.security.springsecurityjpa.repository;

import com.security.springsecurityjpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}

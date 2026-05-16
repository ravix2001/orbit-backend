package com.ravi.orbit.repository;

import com.ravi.orbit.entity.Role;
import com.ravi.orbit.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByRole(ERole role);

    @Query("SELECT ur.role FROM UserRoles ur JOIN ur.user u WHERE u.username = :username")
    Optional<Role> findRoleByUsername(String username);

}

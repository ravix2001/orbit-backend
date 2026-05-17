package com.ravi.orbit.repository;

import com.ravi.orbit.dto.RoleDTO;
import com.ravi.orbit.entity.Role;
import com.ravi.orbit.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByTitle(ERole title);

    @Query("SELECT ur.role " +
            "FROM UserRoles ur " +
            "JOIN ur.user u " +
            "WHERE u.username = :username")
    Optional<Role> findRoleByUsername(String username);

    @Query("SELECT NEW com.ravi.orbit.dto.RoleDTO(r.id, r.title, r.colorCode, r.status) " +
            "FROM Role r")
    List<RoleDTO> getAllRoles();

    @Query("SELECT NEW com.ravi.orbit.dto.RoleDTO(r.id, r.title, r.colorCode, r.status) " +
            "FROM Role r " +
            "WHERE r.id = :id")
    Optional<RoleDTO> getRoleDTOById(UUID id);

    @Query("SELECT NEW com.ravi.orbit.dto.RoleDTO(r.id, r.title, r.colorCode, r.status) " +
            "FROM Role r " +
            "WHERE r.title = :title")
    Optional<RoleDTO> getRoleDTOByTitle(ERole title);

}

package com.ravi.orbit.service;

import com.ravi.orbit.dto.RoleDTO;
import com.ravi.orbit.entity.Role;
import com.ravi.orbit.enums.ERole;

import java.util.List;
import java.util.UUID;

public interface IRoleService {

    RoleDTO handleRole(RoleDTO roleDTO);
    List<RoleDTO> getAllRoles();
    RoleDTO getRoleDTOById(UUID id);
    RoleDTO getRoleDTOByTitle(ERole title);
    void activateRole(UUID id);
    void deactivateRole(UUID id);
    void deleteRole(UUID id);
    Role getRoleById(UUID id);

}

package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.RoleDTO;
import com.ravi.orbit.entity.Role;
import com.ravi.orbit.enums.ERole;
import com.ravi.orbit.enums.EStatus;
import com.ravi.orbit.exceptions.BadRequestException;
import com.ravi.orbit.repository.RoleRepository;
import com.ravi.orbit.service.IRoleService;
import com.ravi.orbit.utils.CommonMethods;
import com.ravi.orbit.utils.MyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleDTO handleRole(RoleDTO roleDTO) {

        Role role = null;

        if(CommonMethods.isEmpty(roleDTO.getId())){
            role = new Role();
        }
        else{
            role = getRoleById(roleDTO.getId());
        }

        role.setTitle(roleDTO.getTitle());
        role.setColorCode(roleDTO.getColorCode());
        roleRepository.save(role);

        roleDTO.setId(role.getId());
        roleDTO.setStatus(role.getStatus());
        return roleDTO;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    public void activateRole(UUID id){
        Role role = getRoleById(id);
        role.setStatus(EStatus.ACTIVE);
        roleRepository.save(role);
    }

    @Override
    public void deactivateRole(UUID id){
        Role role = getRoleById(id);
        role.setStatus(EStatus.INACTIVE);
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(UUID id){
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }

    @Override
    public RoleDTO getRoleDTOById(UUID id) {
        return roleRepository.getRoleDTOById(id)
                .orElseThrow(() -> new BadRequestException(
                        MyConstants.ERR_MSG_NOT_FOUND + "Role: " + id));
    }

    @Override
    public Role getRoleById(UUID id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(
                        MyConstants.ERR_MSG_NOT_FOUND + "Role: " + id));
    }

    @Override
    public RoleDTO getRoleDTOByTitle(ERole title){
        return roleRepository.getRoleDTOByTitle(title)
                .orElseThrow(() -> new BadRequestException(
                        MyConstants.ERR_MSG_NOT_FOUND + "Role: " + title));
    }

}

package com.ravi.orbit.controller;

import com.ravi.orbit.dto.RoleDTO;
import com.ravi.orbit.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping("/handleRole")
    public ResponseEntity<RoleDTO> handleRole(@RequestBody RoleDTO roleDTO){
        return ResponseEntity.ok(roleService.handleRole(roleDTO));
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable UUID id){
        return ResponseEntity.ok(roleService.getRoleDTOById(id));
    }

    @GetMapping(params = "title")
    public ResponseEntity<RoleDTO> getRoleByTitle(@RequestParam String title){
        return ResponseEntity.ok(roleService.getRoleDTOByTitle(title));
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<Void> activateRoleById(@PathVariable UUID id){
        roleService.activateRole(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateRoleById(@PathVariable UUID id){
        roleService.deactivateRole(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id){
        roleService.deleteRole(id);
        return ResponseEntity.ok().build();
    }

}

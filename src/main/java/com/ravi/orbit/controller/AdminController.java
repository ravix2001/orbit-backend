package com.ravi.orbit.controller;

import com.ravi.orbit.dto.UserDTO;
import com.ravi.orbit.service.IAdminService;
import com.ravi.orbit.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final IAdminService adminService;
    private final IUserService userService;

    @PostMapping("/handleUser")
    public ResponseEntity<UserDTO> handleUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.handleUser(userDTO));
    }

    @GetMapping("/createAdmin/{id}")
    public ResponseEntity<String> createAdmin(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.createAdmin(id));
    }

    @GetMapping("/deleteAdmin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }

    @DeleteMapping("/deleteUserHard/{id}")
    public ResponseEntity<Void> deleteUserHard(@PathVariable UUID id) {
        userService.deleteUserHard(id);
        return ResponseEntity.ok().build();
    }

}

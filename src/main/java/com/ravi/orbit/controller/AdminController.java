package com.ravi.orbit.controller;

import com.ravi.orbit.dto.UserDTO;
import com.ravi.orbit.enums.ERole;
import com.ravi.orbit.enums.EStatus;
import com.ravi.orbit.service.IAdminService;
import com.ravi.orbit.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.createAdmin(id));
    }

    @GetMapping("/deleteAdmin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }

    @DeleteMapping("/deleteUserHard/{id}")
    public ResponseEntity<Void> deleteUserHard(@PathVariable Long id) {
        userService.deleteUserHard(id);
        return ResponseEntity.ok().build();
    }

}

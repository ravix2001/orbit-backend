package com.ravi.orbit.service;

import com.ravi.orbit.dto.AuthDTO;
import com.ravi.orbit.dto.UserDTO;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.enums.ERole;
import com.ravi.orbit.enums.EStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IUserService {

    UserDTO handleUser(UserDTO userDTO);

    AuthDTO signup(UserDTO userDTO, ERole role);

    AuthDTO login(String username, String password, ERole role);

    UserDTO updateProfile(UserDTO userDTO, String username);

    UserDTO getUserDTOById(Long id);

    UserDTO getUserDTOByUsername(String username);

    UserDTO getUserAuthByUsername(String username);

    Page<UserDTO> getUsersByRoleAndStatus(ERole role, EStatus status, Pageable pageable);

    void deleteUser(String username);

    void deleteUserHard(Long userId);

    User getUserById(Long id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

}

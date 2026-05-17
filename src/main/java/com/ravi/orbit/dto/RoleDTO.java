package com.ravi.orbit.dto;

import com.ravi.orbit.enums.ERole;
import com.ravi.orbit.enums.EStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class RoleDTO {

    public RoleDTO(UUID id, ERole title, String colorCode, EStatus status) {
        this.id = id;
        this.title = title;
        this.colorCode = colorCode;
        this.status = status;
    }

    private UUID id;

    private ERole title;

    private String colorCode;

    private EStatus status;

}

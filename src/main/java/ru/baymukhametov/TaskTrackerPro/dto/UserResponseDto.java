package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;
import ru.baymukhametov.TaskTrackerPro.Entity.Role;

@Data
public class UserResponseDto {
    private String name;
    private String email;
    private Role role;
}

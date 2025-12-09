package ru.baymukhametov.TaskTrackerPro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.baymukhametov.TaskTrackerPro.Entity.Role;

@Data
public class UserRequestDto {
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(min = 1, max = 20, message = "Имя пользователя должна быть от 1 до 20 символов")
    private String name;
    @NotBlank(message = "Email не может быть пустым")
    private String email;
    @NotBlank(message = "Роль не может быть пустым")
    private Role role;
}
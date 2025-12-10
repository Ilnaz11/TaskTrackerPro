package ru.baymukhametov.TaskTrackerPro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ProjectCreateDto {
    @NotBlank(message = "Имя проекта не должно быть пустым")
    @Size(min = 4, max = 20, message = "Имя проекта должно быть от 4 до 20 символов")
    private String name;
    private String description;
    private Long managerId;
    private LocalDateTime dueDate;
}

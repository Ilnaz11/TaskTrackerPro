package ru.baymukhametov.TaskTrackerPro.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskCreateDto {

    @NotBlank(message = "Название не должно быть пустым")
    @Size(min = 3, max = 20)
    private String title;
    private String description;
//    @NotNull(message = "Статус не может быть пустым")
    private TaskStatus status;
    @Future
    private LocalDateTime dueDate;
    private Long project_id;
    private Long executor_id;
}
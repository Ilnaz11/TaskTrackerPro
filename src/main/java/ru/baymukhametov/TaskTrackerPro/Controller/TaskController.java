package ru.baymukhametov.TaskTrackerPro.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.baymukhametov.TaskTrackerPro.Repository.TaskRepository;
import ru.baymukhametov.TaskTrackerPro.mapper.TaskMapper;

@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @PostMapping
    public

}
//o	создать задачу,
//o	получить все задачи,
//o	обновить статус задачи,
//o	удалить задачу.
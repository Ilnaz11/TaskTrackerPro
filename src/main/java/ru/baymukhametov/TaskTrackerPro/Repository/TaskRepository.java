package ru.baymukhametov.TaskTrackerPro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}

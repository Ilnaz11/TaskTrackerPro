package ru.baymukhametov.TaskTrackerPro.Repository;

import org.hibernate.query.sqm.mutation.internal.temptable.LocalTemporaryTableInsertStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;
import ru.baymukhametov.TaskTrackerPro.Entity.User;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByUser(User user);
}

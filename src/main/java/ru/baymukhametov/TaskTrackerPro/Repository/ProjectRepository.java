package ru.baymukhametov.TaskTrackerPro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}

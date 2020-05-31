package be.taskmanager.taskmanager.repository;

import be.taskmanager.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findTaskById(int id);
}

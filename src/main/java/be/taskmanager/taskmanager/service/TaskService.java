package be.taskmanager.taskmanager.service;

import be.taskmanager.taskmanager.domain.SubTask;
import be.taskmanager.taskmanager.domain.Task;
import be.taskmanager.taskmanager.dto.SubTaskDTO;
import be.taskmanager.taskmanager.dto.TaskDTO;
import be.taskmanager.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepository repository;

    public List<Task> getTasks() {
        //return repository.getTasks();
        return repository.findAll();
    }

    public Task getTask(int id) {
        //return repository.getTask(id);
        return repository.findTaskById(id);
    }

    public void addTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDate());
        //repository.addTask(task);
        repository.save(task);
    }

    public void editTask(TaskDTO taskDTO){
        //repository.updateTask(taskDTO.getId(), taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDate());

        Task task = repository.findTaskById(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDate());
        repository.save(task);
    }

    public void addSubTask(Integer id, SubTaskDTO subTaskDTO) {
        Task task = repository.findTaskById(id);
        SubTask subTask = new SubTask(subTaskDTO.getTitle(), subTaskDTO.getDescription());
        task.addSubTask( subTask);
        System.out.println(task.getSubTasks().toString());
        repository.save(task);
    }
}

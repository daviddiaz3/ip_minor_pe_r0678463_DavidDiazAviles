package be.taskmanager.taskmanager.controller;

import be.taskmanager.taskmanager.dto.SubTaskDTO;
import be.taskmanager.taskmanager.dto.TaskDTO;
import be.taskmanager.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service){this.service = service;}

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", service.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("task", service.getTask(id));
        if(service.getTask(id) == null ) {
            model.addAttribute("error", "Task not found");
            return "error";
            // make task exception
        }
        else
            return "taskDetail";
    }

    @GetMapping("/tasks/new")
    public String createTaskPage(Model model){
        return "createTask";
    }

    @PostMapping("/tasks/createTask")
    public String createTask(@ModelAttribute TaskDTO taskDTO){
        service.addTask(taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTaskPage(Model model, @PathVariable("id") Integer id){
        model.addAttribute("task", service.getTask(id));
        if(service.getTask(id) == null ) {
            model.addAttribute("error", "Task not found");
            return "error";
            // make task exception
        }
        else
            return "editTask";
    }

    @PostMapping("/tasks/editTask")
    public String editTask(Model model, @ModelAttribute TaskDTO taskDTO){
        service.editTask(taskDTO);
        return "redirect:/tasks/" +taskDTO.getId();
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String createSubTaskPage(Model model, @PathVariable("id") Integer id){
        model.addAttribute("task", service.getTask(id));
        return "createSubTask";
    }

    @PostMapping("/tasks/createSubTask/{id}")
    public String createSubTask(Model model, @ModelAttribute SubTaskDTO subTaskDTO, @PathVariable("id") Integer id){
        service.addSubTask(id, subTaskDTO);
        return "redirect:/tasks/" +id ;
    }

}

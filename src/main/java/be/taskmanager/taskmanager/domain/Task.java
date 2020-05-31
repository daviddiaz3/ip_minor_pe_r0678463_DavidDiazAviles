package be.taskmanager.taskmanager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String description;
    private String dueDate;

    @ElementCollection
    private List<SubTask> subTasks;

//    public Task(int id, String title, String description, String dueDate){
//        setId(id);
//        setTitle(title);
//        setDescription(description);
//        setDueDate(dueDate);
//        this.subTasks = new ArrayList<SubTask>();
//    }

    public Task() {

    }

    public Task( String title, String description, String dueDate){
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        this.subTasks = new ArrayList<SubTask>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(SubTask subTask){
        if(this.subTasks == null) {
            this.subTasks = new ArrayList<SubTask>();
        }
        this.subTasks.add(subTask);
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }
}

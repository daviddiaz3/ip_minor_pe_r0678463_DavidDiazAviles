package be.taskmanager.taskmanager.domain;

import javax.persistence.Embeddable;

@Embeddable
public class SubTask {

    private String title;
    private String description;

    public SubTask(){

    }

    public SubTask(String title, String description){
        setDescription(description);
        setTitle(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

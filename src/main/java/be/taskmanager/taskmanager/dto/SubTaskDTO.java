package be.taskmanager.taskmanager.dto;

public class SubTaskDTO {

    private String title;
    private String description;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

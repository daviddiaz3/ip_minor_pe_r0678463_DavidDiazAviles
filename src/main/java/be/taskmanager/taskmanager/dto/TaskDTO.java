package be.taskmanager.taskmanager.dto;

public class TaskDTO {

    private int id;
    private String title;
    private String description;
    private String date;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date.replaceAll("T", " ");
    }

    public void setId(int id) {
        this.id = id;
    }
}
